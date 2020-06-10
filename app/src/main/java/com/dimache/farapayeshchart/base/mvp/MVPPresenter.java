package com.dimache.farapayeshchart.base.mvp;

import com.dimache.farapayeshchart.base.mvp.contract.Base;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by User on 11/28/2017.
 */

public class MVPPresenter<V extends Base.View> implements Base.Presenter {

    // view (MVP)
    protected V view;
    // handler observables for dispose and subscribe
    protected CompositeDisposable compositeDisposable;

    @Inject
    public MVPPresenter(V view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void subscribe()
    {

    }

    @Override
    public void unSubscribe() {
        compositeDisposable.clear();
    }

    @Override
    public void deAttach() {
        unSubscribe();
//        this.view = null;
}


}
