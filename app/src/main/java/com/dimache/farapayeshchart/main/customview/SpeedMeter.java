package com.dimache.farapayeshchart.main.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import com.dimache.farapayeshchart.R;

public class SpeedMeter extends RelativeLayout {

    private AppCompatTextView circleText;
    private RelativeLayout rl_center;
    private SpeedView speedView;

    public SpeedMeter(Context context) {
        super(context);
    }

    public SpeedMeter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public SpeedMeter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    public SpeedMeter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs)
    {
        circleText = new AppCompatTextView(context);
        circleText.setGravity(Gravity.CENTER);
        circleText.setTextSize(16f);
        circleText.setText("Farapayesh CustomView");
        circleText.setTextColor(ContextCompat.getColor(context, R.color.text));

        speedView = new SpeedView(context);
        rl_center = new RelativeLayout(context);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        rl_center.setId(ViewCompat.generateViewId());
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);


        rl_center.addView(circleText,layoutParams);
        rl_center.addView(speedView);


        this.addView(rl_center);

    }

    public SpeedView getSpeedView()
    {
        return speedView;
    }

}
