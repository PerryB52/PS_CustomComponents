package com.example.alexandrup.ps_customcomponents.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.alexandrup.ps_customcomponents.R;

/**
 * Created by alexandrup on 1/28/2017.
 */

public class Pizza extends View {

    private Paint paint;
    private int numWedges;

    public Pizza(Context context) {
        super(context);
        init(context, null);
    }

    public Pizza(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Pizza(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){

        int strokeWidth = 16;
        int color = Color.YELLOW;

        if(attrs != null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Pizza);
            strokeWidth = array.getDimensionPixelSize(R.styleable.Pizza_stroke_width, strokeWidth);
            color = array.getColor(R.styleable.Pizza_color, color);
            numWedges = array.getInt(R.styleable.Pizza_num_wedges, numWedges);
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
    }



    @Override
    protected void onDraw(Canvas canvas) {

        final int width = getWidth() - getPaddingLeft() - getPaddingRight();
        final int height = getHeight() - getPaddingTop() - getPaddingBottom();

        final int cx = width / 2 + getPaddingLeft();
        final int cy = height / 2 + getPaddingTop();
        final float diameter = Math.min(width, height) - paint.getStrokeWidth();
        final float radius = diameter / 2;

        canvas.drawCircle(cx, cy, radius, paint);
        drawPizzaCuts(canvas, cx, cy, radius);

    }

    private void drawPizzaCuts(Canvas canvas, float cx, float cy, float radius){

        final float degress = 360f / numWedges;

        canvas.save();

        for(int i = 0; i < numWedges; ++i){
            canvas.rotate(degress, cx, cy);
            canvas.drawLine(cx, cy, cx, cy - radius, paint);

        }

        canvas.restore();

    }
}
