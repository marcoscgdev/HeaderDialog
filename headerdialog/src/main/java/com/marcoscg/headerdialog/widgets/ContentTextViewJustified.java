package com.marcoscg.headerdialog.widgets;

/**
 * Created by marcos on 15/01/2017.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public final class ContentTextViewJustified
        extends TextView {

    public ContentTextViewJustified(Context context) {
        super(context);
        init();
    }

    public ContentTextViewJustified(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContentTextViewJustified(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ContentTextViewJustified(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();

        String text = getText().toString();

        float lineY = 0;
        lineY += getTextSize() * 1f;

        final Layout layout = getLayout();
        final float desiredLineWidth = getMeasuredWidth();

        for (int i = 0, lineCount = layout.getLineCount(); i < lineCount; i++) {
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            String line = text.substring(lineStart, lineEnd);

            if (needScale(line) && i < lineCount - 1) {
                drawScaledText(line, canvas, lineY, desiredLineWidth, paint);
            } else {
                canvas.drawText(line, 0, lineY, paint);
            }

            lineY += getLineHeight();
        }
    }

    private void drawScaledText(final String line, final Canvas canvas, final float y, final float desiredLineWidth, final TextPaint paint) {
        String[] words = line.split(" ");

        float lineWidthWithoutSpaces = StaticLayout.getDesiredWidth(line.replace(" ", ""), getPaint());
        float spacing = (desiredLineWidth - lineWidthWithoutSpaces) / (words.length - 1);

        float x = 0;
        for (String word : words) {
            float cw = StaticLayout.getDesiredWidth(word, paint);
            canvas.drawText(word, x, y, paint);
            x += cw + spacing;
        }
    }

    private boolean needScale(String line) {
        if (line.length() == 0) {
            return false;
        } else {
            return line.charAt(line.length() - 1) != '\n';
        }
    }
    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "regular.ttf");
        setTypeface(tf);
    }
}