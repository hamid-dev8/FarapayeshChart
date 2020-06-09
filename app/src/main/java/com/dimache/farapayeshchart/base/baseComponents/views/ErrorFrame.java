package com.dimache.farapayeshchart.base.baseComponents.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.dimache.farapayeshchart.R;

/**
 * Created by User on 1/3/2018.
 */

public class ErrorFrame extends FrameLayout implements DataLoaderView {

    Button retry;
    ReTryListener reTryListener;

    public ErrorFrame(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ErrorFrame(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ErrorFrame(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ErrorFrame(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.error, this, true);
        retry = view.findViewById(R.id.retry);
        retry = findViewById(R.id.retry);
        retry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reTryListener != null)
                    reTryListener.retry();
            }
        });
    }

    public interface ReTryListener
    {
        void retry();
    }


    public ReTryListener getReTryListener() {
        return reTryListener;
    }

    public void setReTryListener(ReTryListener reTryListener) {
        this.reTryListener = reTryListener;
    }

    public void show()
    {
        setVisibility(VISIBLE);
    }

    public void dismiss()
    {
        setVisibility(GONE);
    }
}
