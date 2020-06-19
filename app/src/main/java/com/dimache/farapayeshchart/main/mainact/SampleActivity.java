package com.dimache.farapayeshchart.main.mainact;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dimache.farapayeshchart.R;
import com.dimache.farapayeshchart.main.utils.AspectRatioImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleActivity extends AppCompatActivity {


    @BindView(R.id.image)
    AspectRatioImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio);
        ButterKnife.bind(this);
        image.setAspectRatioEnabled(true);
        image.setAspectRatio(1f);
    }
}
