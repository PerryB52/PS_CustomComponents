package com.example.alexandrup.ps_customcomponents.CustomViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alexandrup.ps_customcomponents.R;

/**
 * Created by alexandrup on 1/25/2017.
 */

public class LengthPicker extends LinearLayout {

    private View mPlusButton;
    private TextView mTextView;
    private View mMinusButton;

    private int mNumInches = 0;



    public LengthPicker(Context context) {
        super(context);
        init();
    }

    public LengthPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.length_picker, this);


        mPlusButton = findViewById(R.id.plus_button);
        mTextView = (TextView) findViewById(R.id.text);
        mMinusButton = findViewById(R.id.minus_button);

        updateControls();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.plus_button:
                        mNumInches++;
                        updateControls();
                        break;
                    case R.id.minus_button:
                        if (mNumInches > 0) {
                            mNumInches--;
                            updateControls();
                        }
                        break;
                }
            }
        };
        mPlusButton.setOnClickListener(listener);
        mMinusButton.setOnClickListener(listener);

        setBackgroundColor(Color.LTGRAY);
    }

    private void updateControls() {

        int feet = mNumInches / 12;
        int inches = mNumInches % 12;

        String text = String.format("%d' %d\"", feet, inches);
        if(feet == 0){
            text = String.format("%d\"", inches);
        } else {
            if(inches == 0){
                text = String.format("%d'", feet);
            }
        }

        mTextView.setText(text);

        mMinusButton.setEnabled(mNumInches > 0);

    }
}
