package com.marcoscg.headerdialog.widgets;

/**
 * Created by marcos on 15/01/2017.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class ContentTextView extends TextView {

    public ContentTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ContentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContentTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "regular.ttf");
        setTypeface(tf);
    }

}