package com.dimache.farapayeshchart.main.mainact.pie;

import com.dimache.farapayeshchart.base.mvp.contract.Base;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;

import java.util.List;

public interface PieContract {
    interface View extends Base.DataView{
        void showTotals(List<TotalInfected> totalInfected);
    }

    interface Presenter extends Base.Presenter{
        void getTotals();
    }
}
