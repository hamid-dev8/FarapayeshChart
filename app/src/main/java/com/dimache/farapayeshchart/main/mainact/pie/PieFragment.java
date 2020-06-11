package com.dimache.farapayeshchart.main.mainact.pie;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.dimache.farapayeshchart.App;
import com.dimache.farapayeshchart.R;
import com.dimache.farapayeshchart.base.mvp.MVPDataFragment;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class PieFragment extends MVPDataFragment<PieContract.Presenter> implements PieContract.View {

    private Unbinder unbinder;
    @BindView(R.id.pie_chart)
    PieChart pieChart;


    public static PieFragment newInstance() {
        return new PieFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pie, container, false);
        unbinder = ButterKnife.bind(this, view);

        presenter.getTotals();

        return view;
    }

    @Override
    public void showTotals(List<TotalInfected> totalInfected) {
        TotalInfected infected = totalInfected.get(0);
        List<PieEntry> entries = new ArrayList<PieEntry>();

        int MY_COLORS[] = {ContextCompat.getColor(this.getActivity(), R.color.confirmed),
                ContextCompat.getColor(this.getActivity(), R.color.critical),
                ContextCompat.getColor(this.getActivity(), R.color.death),
                ContextCompat.getColor(this.getActivity(), R.color.recovered),
                ContextCompat.getColor(this.getActivity(), R.color.active_cases)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        entries.add(new PieEntry(infected.getConfirmed(), "Confirmed"));
        entries.add(new PieEntry(infected.getCritical(), "Critical"));
        entries.add(new PieEntry(infected.getDeaths(), "Deaths"));
        entries.add(new PieEntry(infected.getRecovered(), "Recovered"));
        entries.add(new PieEntry(infected.getTotal_active_cases(), "ActiveCases"));

        for (int c : MY_COLORS) colors.add(c);

        PieDataSet set = new PieDataSet(entries, "CoronaVirus Results");
        set.setColors(colors);
        set.setUsingSliceColorAsValueLineColor(true);
        set.setValueTextColor(ContextCompat.getColor(this.getActivity(),R.color.white));
        set.setValueTextSize(12f);
        PieData data = new PieData(set);
        pieChart.setCenterText("FaraPayesh Amin Co.");
        pieChart.setCenterTextColor(ContextCompat.getColor(this.getActivity(),R.color.text));
        pieChart.setCenterTextSize(16f);
        pieChart.setData(data);
        pieChart.animateXY(500,500);
        pieChart.invalidate();
        //Toast.makeText(this.getActivity(),totalInfected1.getConfirmed(),Toast.LENGTH_LONG).show();
    }
}
