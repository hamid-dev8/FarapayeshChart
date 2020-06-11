package com.dimache.farapayeshchart.main.data.repository.imp;

import com.dimache.farapayeshchart.base.di.Remote;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;
import com.dimache.farapayeshchart.main.data.repository.TotalInfectedRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TotalInfectedRepositoryImp implements TotalInfectedRepository {

    @Remote
    TotalInfectedRepository remote;

    @Inject
    public TotalInfectedRepositoryImp(@Remote TotalInfectedRepository remote)
    {
        this.remote = remote;
    }

    @Override
    public Observable<List<TotalInfected>> getTotalInfected() {
        return remote.getTotalInfected();
    }
}
