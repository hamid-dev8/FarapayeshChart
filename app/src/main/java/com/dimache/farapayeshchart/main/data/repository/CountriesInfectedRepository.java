package com.dimache.farapayeshchart.main.data.repository;

import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;

import java.util.List;
import java.util.Set;

import io.reactivex.Observable;

public interface CountriesInfectedRepository
{
    Observable<CountriesMap> getCountriesInfected();
}
