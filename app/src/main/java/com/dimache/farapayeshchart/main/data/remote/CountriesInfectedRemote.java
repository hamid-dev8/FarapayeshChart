package com.dimache.farapayeshchart.main.data.remote;

import com.dimache.farapayeshchart.base.remote.RetrofitBuilder;
import com.dimache.farapayeshchart.base.remote.WebApi;
import com.dimache.farapayeshchart.base.remote.util.RemoteModel;
import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;
import com.dimache.farapayeshchart.main.data.repository.CountriesInfectedRepository;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class CountriesInfectedRemote implements CountriesInfectedRepository {

    WebApi api;


    @Inject
    public CountriesInfectedRemote()
    {
        api = RetrofitBuilder.getWebApi();
    }

    @Override
    public Observable<CountriesMap> getCountriesInfected() {
        return api.getCountriesInfected();
        /*.flatMap(new Function<RemoteModel<List<CountriesMap>, Object>, ObservableSource<? extends List<CountriesMap>>>() {
            @Override
            public ObservableSource<? extends List<CountriesMap>> apply(RemoteModel<List<CountriesMap>, Object> countriesMapObjectRemoteModel) throws Exception {
                return Observable.just(countriesMapObjectRemoteModel.getData2());
            }
        });*/
    }
}
