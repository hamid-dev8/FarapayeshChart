package com.dimache.farapayeshchart.main.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.dimache.farapayeshchart.R;

public class SpeedView extends View {

    float radius;
    float center_x, center_y;
    float pointerOffset = 25;
    private RectF oval;
    private int speed = 0;
    Path path;

    public SpeedView(Context context) {
        super(context);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SpeedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        DrawArc(canvas);
        DrawPointer(canvas);
    }


    public void DrawPointer(Canvas canvas) {
        final int totalNoPointers = 120;
        final int pointerMaxHeight = 20;
        final int pointerMinHeight = 14;

        int startPointerX = (int) (center_x - radius - pointerOffset);
        int startPointerY = (int) (center_y - pointerOffset);

        Paint pointerPaint = new Paint();
        pointerPaint.setStrokeCap(Paint.Cap.ROUND);
        pointerPaint.setStrokeWidth(5);
        pointerPaint.setColor(ContextCompat.getColor(getContext(), R.color.blue));

        Paint pointerTextPaint = new Paint();
        pointerTextPaint.setStrokeWidth(5);
        pointerTextPaint.setTextSize(22f);
        pointerTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.text));

        int pointerHeight;

        canvas.rotate(312f, center_x, center_y);
        Bitmap textBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas textCanvas = new Canvas(textBitmap);


        for (int i = 0; i < totalNoPointers; i++) {
            if (i % 5 == 0) {
                pointerHeight = pointerMaxHeight;

            } else {
                pointerHeight = pointerMinHeight;
            }
            canvas.drawLine(startPointerX, startPointerY, startPointerX - pointerHeight, startPointerY, pointerPaint);
            canvas.rotate(270f / totalNoPointers, center_x, center_y);
        }
    }

    private void DrawArc(Canvas canvas) {
        float width = (float) getWidth();
        float height = (float) getHeight();

        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }


        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);

        Paint pointPaint = new Paint();
        pointPaint.setColor(ContextCompat.getColor(getContext(), R.color.confirmed));
        pointPaint.setStrokeWidth(50);
        pointPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        pointPaint.setStrokeCap(Paint.Cap.ROUND);

        Paint arcPaint = new Paint();
        arcPaint.setColor(ContextCompat.getColor(getContext(), R.color.light_confirmed));
        arcPaint.setStrokeWidth(3);
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setStrokeCap(Paint.Cap.BUTT);



        path = new Path();
        oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);


        center_x = width / 2;
        center_y = height / 2;


        oval.set(center_x - radius,
                center_y - radius,
                center_x + radius,
                center_y + radius);
        path.setLastPoint(center_x, center_y);

        if (speed < 270 && speed > 0)
            path.arcTo(oval, 135, speed);

        canvas.drawPath(path, arcPaint);
        canvas.drawArc(oval, 135, 270, false, paint);
        canvas.drawPoint(center_x, center_y, pointPaint);
        pointPaint.setStrokeWidth(20f);
        canvas.save();
    }

    public void SpeedSeter(int speed) {
        this.speed = speed;
    }

    public int StartAngle() {
        int startAngle = (int) (270 / Math.PI * Math.atan2(center_y - 135, center_x - 135));
        return startAngle;
    }
}
