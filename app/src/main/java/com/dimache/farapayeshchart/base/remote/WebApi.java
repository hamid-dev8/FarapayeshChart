package com.dimache.farapayeshchart.base.remote;

import com.dimache.farapayeshchart.base.remote.util.RemoteModel;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WebApi
{
    @GET("free-api?global=stats")
    Observable<RemoteModel<List<TotalInfected>,Object>> getTotal();


}
