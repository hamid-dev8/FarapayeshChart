package com.dimache.farapayeshchart.main.mainact.line;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.dimache.farapayeshchart.R;
import com.dimache.farapayeshchart.base.mvp.MVPDataFragment;
import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;
import com.dimache.farapayeshchart.main.utils.IndexAxisValueFormatter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LineFragment extends MVPDataFragment<LineContract.Presenter> implements LineContract.View {


    private Unbinder unbinder;
    @BindView(R.id.line_chart)
    LineChart lineChart;


    public static LineFragment newInstance() {
        return new LineFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line, container, false);
        unbinder = ButterKnife.bind(this, view);

        setLineDataMetric();

        return view;
    }


    public void setLineDataMetric()
    {
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry(0f,2f));
        entries.add(new Entry(5f,30.24f));
        entries.add(new Entry(10f,25.2f));
        entries.add(new Entry(20f,1023.f));
        entries.add(new Entry(30f,24f));
        LineDataSet dataSet = new LineDataSet(entries, "Countries Log");// add entries to dataset
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setColor(ContextCompat.getColor(this.getActivity(), R.color.blue));
        dataSet.setValueTextColor(ContextCompat.getColor(this.getActivity(), R.color.text));

        LineData lineData = new LineData(dataSet);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.setData(lineData);
        lineChart.animateXY(500,2000);
        lineChart.invalidate(); // refresh
    }

    @Override
    public void showOnCountries(CountriesMap countriesInfecteds) {

       Set<String> xSet = new HashSet<String>();
       Set<String> ySet = new HashSet<String>();
    }

}
