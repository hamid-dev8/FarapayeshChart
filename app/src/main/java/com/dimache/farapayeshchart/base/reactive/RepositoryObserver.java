package com.dimache.farapayeshchart.base.reactive;


/*
    create by Hamidreza
 * observer for Repository Observables. handle error and wrapp methodes
 */

import com.dimache.farapayeshchart.base.remote.util.NotFoundException;
import com.dimache.farapayeshchart.base.remote.util.RemoteModel;
import com.dimache.farapayeshchart.base.remote.util.ServerErrorException;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class RepositoryObserver<T> implements Observer<T> {

    @Override
    public void onNext(T t) {
        if (t == null)
            onNotFound();
        else if (t instanceof List && ((List) t).isEmpty())
            onNotFound();
        else
            onResponse(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            switch (((HttpException) e).code()) {
                case 400:
                case 404:
                    onNotFound();
                    break;
                case 500:
                    onFailure(new ServerErrorException());
                    break;
                case 409:
                    RemoteModel model = null;
                    try {
                        model = new Gson().fromJson(((HttpException) e).response().errorBody().string(), RemoteModel.class);
                    } catch (Exception e1) {
                        model = new RemoteModel();
                        model.setMessage("خطا ارتباط با سرور");
                    }
                    onFailure(new ServerErrorException(model.getMessage()));
                    break;
                default:
                    onFailure(e);
            }
        }
        else if (e instanceof NotFoundException)
            onNotFound();
        else if (e instanceof NullPointerException)
            onNotFound();
        else
            onFailure(e);
    }

    @Override
    public void onComplete() {

    }

    /*call when success get [data]
     * @param t is [data]
     * */
    public abstract void onResponse(T t);

    /*call when data not found or is empty*/
    public abstract void onNotFound();

    /*call when fail get data*/
    public abstract void onFailure(Throwable e);
}
