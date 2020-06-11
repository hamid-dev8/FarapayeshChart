package com.dimache.farapayeshchart.main.data.remote;

import com.dimache.farapayeshchart.base.remote.RetrofitBuilder;
import com.dimache.farapayeshchart.base.remote.WebApi;
import com.dimache.farapayeshchart.base.remote.util.RemoteModel;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;
import com.dimache.farapayeshchart.main.data.repository.TotalInfectedRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class TotalInfectedRemote implements TotalInfectedRepository {

    WebApi api;


    @Inject
    public TotalInfectedRemote()
    {
        api = RetrofitBuilder.getWebApi();
    }

    @Override
    public Observable<List<TotalInfected>> getTotalInfected() {
        return api.getTotal().flatMap(new Function<RemoteModel<List<TotalInfected>, Object>, ObservableSource<? extends List<TotalInfected>>>() {
            @Override
            public ObservableSource<? extends List<TotalInfected>> apply(RemoteModel<List<TotalInfected>, Object> listObjectRemoteModel) throws Exception {
                return Observable.just(listObjectRemoteModel.getData());
            }
        });
    }
}
