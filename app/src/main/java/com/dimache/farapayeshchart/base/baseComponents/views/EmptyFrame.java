package com.dimache.farapayeshchart.base.baseComponents.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.dimache.farapayeshchart.R;


/**
 * Created by User on 1/3/2018.
 */

public class EmptyFrame extends FrameLayout implements DataLoaderView{




    public EmptyFrame(@NonNull Context context) {
        super(context);
        init(context);
    }

    public EmptyFrame(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmptyFrame(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EmptyFrame(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.empty, this, true);
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
