package com.dimache.farapayeshchart.main.data.repository.imp;

import com.dimache.farapayeshchart.base.di.Remote;
import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;
import com.dimache.farapayeshchart.main.data.repository.CountriesInfectedRepository;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountriesInfectedRepositoryImp implements CountriesInfectedRepository {


    @Remote
    CountriesInfectedRepository remote;

    @Inject
    public CountriesInfectedRepositoryImp(@Remote CountriesInfectedRepository remote)
    {
        this.remote = remote;
    }

    @Override
    public Observable<CountriesMap> getCountriesInfected() {
        return remote.getCountriesInfected();
    }
}
