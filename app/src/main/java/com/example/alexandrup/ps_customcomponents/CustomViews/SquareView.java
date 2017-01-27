package com.example.alexandrup.ps_customcomponents.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by alexandrup on 1/27/2017.
 */

public class SquareView extends View {

    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());

        setMeasuredDimension(size, size);
    }
}
