package com.dimache.farapayeshchart.base.mvp;

import com.dimache.farapayeshchart.base.mvp.contract.Base;
import com.dimache.farapayeshchart.base.reactive.MyReactiveNetwork;

import io.reactivex.disposables.Disposable;

/**
 * Created by User on 1/14/2018.
 */

public abstract class MVPNetPresenter<V extends Base.View> extends MVPPresenter<V> implements MyReactiveNetwork.ConnectivityListener {

    Disposable internetDisposable;

    public MVPNetPresenter(V view) {
        super(view);
    }

    @Override
    public void subscribe() {
        super.subscribe();
        internetDisposable = MyReactiveNetwork.observeInternetConnectivity(this);
    }

    abstract void request();

    @Override
    public void unSubscribe() {
        super.unSubscribe();
        if (internetDisposable != null && !internetDisposable.isDisposed())
            internetDisposable.dispose();
    }


    @Override
    public void connected() {
        if (view != null && view instanceof Base.NetView)
            ((Base.NetView) view).connected();
    }

    @Override
    public void disconnected() {
        if (view != null && view instanceof Base.NetView)
            ((Base.NetView) view).disConnected();
    }
}
