package com.marcoscg.headerdialog.widgets;

/**
 * Created by marcos on 15/01/2017.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TitleTextView extends AppCompatTextView {

    public TitleTextView(Context context) {
        super(context);
        init();
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "medium.ttf");
        setTypeface(tf);
    }

}