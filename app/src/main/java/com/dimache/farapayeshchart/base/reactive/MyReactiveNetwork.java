package com.dimache.farapayeshchart.base.reactive;

import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyReactiveNetwork {
    public interface ConnectivityListener {
        void connected();

        void disconnected();
    }

    /*
     * check internet connection and call listener
     * @param listener connection listener
     */
    public static Disposable observeInternetConnectivity(ConnectivityListener listener){

        return ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean)
                        {
                            if (listener != null)
                                listener.connected();
                        }
                        else {
                            if (listener != null)
                                listener.disconnected();
                        }
                    }
                });


    }
}
