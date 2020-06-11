package com.dimache.farapayeshchart.main.mainact.line;

import com.dimache.farapayeshchart.base.mvp.contract.Base;
import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;

import java.util.List;
import java.util.Set;

public interface LineContract {

    interface View extends Base.DataView{
        void showOnCountries(CountriesMap countriesInfecteds);
    }

    interface Presenter extends Base.Presenter{
        void getOnCountries();
    }
}
