package com.dimache.farapayeshchart.main.speedoact;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dimache.farapayeshchart.R;
import com.dimache.farapayeshchart.main.customview.SpeedMeter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeedActivity extends AppCompatActivity {

    @BindView(R.id.speed_meter)
    SpeedMeter speedMeter;
    String speed = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        ButterKnife.bind(this);


        speed = getIntent().getStringExtra("speed");
        if (speed.equals(""))
            speed = "0";
        else
            speedMeter.getSpeedView().SpeedSeter(Integer.valueOf(speed));
    }
}
