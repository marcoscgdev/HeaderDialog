package com.marcoscg.headerdialog;

/**
 * Created by marcos on 14/01/2017.
 */

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marcoscg.headerdialog.widgets.ContentTextView;
import com.marcoscg.headerdialog.widgets.ContentTextViewJustified;

import java.util.Locale;

public class HeaderDialog extends AlertDialog.Builder {

    private ContentTextViewJustified ctvj;
    private ContentTextView ctv;
    private TextView tv;
    private ImageView iv;
    private LinearLayout ly;
    private View shadow;
    private Context ctx;
    private boolean setElevation = true;

    public HeaderDialog(Context context) {
        super(context);
        ctx = context;
        setView(context);
    }

    public HeaderDialog(final Context context, final int theme) {
        super(context, theme);
        ctx = context;
        setView(context);
    }

    public HeaderDialog setTitle(CharSequence title) {
        tv.setText(title);
        if (Locale.getDefault().getLanguage().equals("ar"))
            tv.setGravity(Gravity.RIGHT);
        tv.setVisibility(View.VISIBLE);
        if (ly.getVisibility() == View.GONE)
            ly.setVisibility(View.VISIBLE);
        if (shadow.getVisibility() == View.GONE && setElevation)
            shadow.setVisibility(View.VISIBLE);
        if (iv.getVisibility() == View.VISIBLE)
            tv.setPadding(0,dpToPx(8),0,0);
        return this;
    }

    public HeaderDialog setMessage(CharSequence message) {
        ctv.setText(message);
        ctvj.setText(message);
        if (Locale.getDefault().getLanguage().equals("ar"))
            ctv.setGravity(Gravity.RIGHT);
        return this;
    }

    public HeaderDialog setColor(int color) {
        ly.setBackgroundColor(color);
        return this;
    }

    public HeaderDialog setTitleColor(int color) {
        tv.setTextColor(color);
        return this;
    }

    public HeaderDialog setIconColor(int color) {
        iv.getDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN );
        return this;
    }

    public HeaderDialog setTitleGravity(int gravity) {
        tv.setGravity(gravity);
        return this;
    }

    public HeaderDialog setMessageGravity(int gravity) {
        ctv.setGravity(gravity);
        return this;
    }

    public HeaderDialog setIcon (int icon) {
        iv.setImageResource(icon);
        iv.setVisibility(View.VISIBLE);
        if (ly.getVisibility() == View.GONE)
            ly.setVisibility(View.VISIBLE);
        if (shadow.getVisibility() == View.GONE && setElevation)
            shadow.setVisibility(View.VISIBLE);
        return this;
    }

    public HeaderDialog setIcon (Drawable icon) {
        iv.setImageDrawable(icon);
        iv.setVisibility(View.VISIBLE);
        if (ly.getVisibility() == View.GONE)
            ly.setVisibility(View.VISIBLE);
        if (shadow.getVisibility() == View.GONE && setElevation)
            shadow.setVisibility(View.VISIBLE);
        return this;
    }

    public HeaderDialog justifyContent(boolean justify) {
        if (justify) {
            if (ctv.getVisibility() == View.VISIBLE)
                ctv.setVisibility(View.GONE);
            if (ctvj.getVisibility() == View.GONE)
                ctvj.setVisibility(View.VISIBLE);
        }
        else {
            if (ctv.getVisibility() == View.GONE)
                ctv.setVisibility(View.VISIBLE);
            if (ctvj.getVisibility() == View.VISIBLE)
                ctvj.setVisibility(View.GONE);
        }
        return this;
    }

    public HeaderDialog setElevation(boolean elevation) {
        setElevation = elevation;
        return this;
    }

    public HeaderDialog setTitleMultiline(boolean multiline) {
        if (!multiline)
            tv.setMaxLines(1);
        return this;
    }

    private void setView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_dialog_content, null);
        ctvj = (ContentTextViewJustified) view.findViewById(R.id.content_justified);
        ctv = (ContentTextView) view.findViewById(R.id.content);
        tv = (TextView) view.findViewById(R.id.title);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        ctv.setMovementMethod(LinkMovementMethod.getInstance());
        iv = (ImageView) view.findViewById(R.id.icon);
        ly = (LinearLayout) view.findViewById(R.id.layout);
        shadow = view.findViewById(R.id.top_shadow);
        setView(view);
    }

    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
