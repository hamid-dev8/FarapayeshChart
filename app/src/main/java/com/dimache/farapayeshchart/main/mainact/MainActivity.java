package com.dimache.farapayeshchart.main.mainact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dimache.farapayeshchart.R;
import com.dimache.farapayeshchart.base.baseComponents.BaseActivity;
import com.dimache.farapayeshchart.main.mainact.line.LineFragment;
import com.dimache.farapayeshchart.main.mainact.pie.PieFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Binds;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    ConstraintLayout container;
    @BindView(R.id.pie_chart_txt)
    TextView txt_pie;
    @BindView(R.id.line_chart_txt)
    TextView txt_line;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        txt_pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment(new PieFragment(), "pie", true, container.getId());
            }
        });

        txt_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new LineFragment(),"line",true,container.getId());
            }
        });
    }
}
