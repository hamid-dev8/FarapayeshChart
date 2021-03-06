package com.dimache.farapayeshchart.main.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.dimache.farapayeshchart.R;

public class AspectRatioImageView extends AppCompatImageView {


    public static final int MEASUREMENT_WIDTH = 0;
    public static final int MEASUREMENT_HEIGHT = 1;


    private static final float DEFAULT_ASPECT_RATIO = 1f;
    private static final boolean DEFAULT_ASPECT_RATIO_ENABLED = false;
    private static final int DEFAULT_DOMINANT_MEASUREMENT = MEASUREMENT_WIDTH;


    private float aspectRatio;
    private boolean aspectRatioEnabled;
    private int dominantMeasurement;


    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context, attrs);
    }


    public void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        aspectRatio = a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, DEFAULT_ASPECT_RATIO);
        aspectRatioEnabled = a.getBoolean(R.styleable.AspectRatioImageView_aspectRatioEnabled,
                DEFAULT_ASPECT_RATIO_ENABLED);
        dominantMeasurement = a.getInt(R.styleable.AspectRatioImageView_dominantMeasurement,
                DEFAULT_DOMINANT_MEASUREMENT);


        a.recycle();


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!aspectRatioEnabled) return;
        else {

            int newWidth;
            int newHeight;

            switch (dominantMeasurement) {
                case MEASUREMENT_WIDTH:
                    newWidth = getMeasuredWidth();
                    newHeight = (int) (newWidth / aspectRatio);
                    break;

                case MEASUREMENT_HEIGHT:
                    newHeight = getMeasuredHeight();
                    newWidth = (int) (newHeight / aspectRatio);
                    break;

                default:
                    throw new IllegalStateException("Unknown measurement with ID " + dominantMeasurement);
            }

            setMeasuredDimension(newWidth, newHeight);

            requestLayout();
        }
    }
    /**
     * Set the aspect ratio for this image view. This will update the view instantly.
     */
    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        if (aspectRatioEnabled) {
            requestLayout();
        }
    }


    /**
     * Get the aspect ratio for this image view.
     */
    public float getAspectRatio() {
        return aspectRatio;
    }

    public boolean getAspetRatioEnabled() {
        return aspectRatioEnabled;
    }

    public void setAspectRatioEnabled(boolean aspectRatioEnabled) {
        this.aspectRatioEnabled = aspectRatioEnabled;
        requestLayout();
    }

    @Override
    public boolean getAdjustViewBounds() {
        return super.getAdjustViewBounds();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
    }

    @Override
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        super.setAdjustViewBounds(adjustViewBounds);

    }


}
