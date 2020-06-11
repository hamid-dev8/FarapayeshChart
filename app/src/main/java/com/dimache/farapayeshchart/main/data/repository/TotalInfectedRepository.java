package com.dimache.farapayeshchart.main.data.repository;

import com.dimache.farapayeshchart.main.data.model.TotalInfected;

import java.util.List;

import io.reactivex.Observable;

public interface TotalInfectedRepository
{
    Observable<List<TotalInfected>> getTotalInfected();
}
