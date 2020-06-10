package com.dimache.farapayeshchart.base.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.dimache.farapayeshchart.base.mvp.contract.Base;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


/**
 * Created by User on 11/28/2017.
 *
 * base of fragments that are view (MVP)
 */

public abstract class MVPFragment<P extends Base.Presenter> extends DaggerFragment implements Base.View
{
    //presenter of view
    @Inject
    protected P presenter;

    protected View progress;

//    protected abstract P createPresenter();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        presenter = createPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.deAttach();
    }

}
