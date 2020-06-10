package com.dimache.farapayeshchart.base.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dimache.farapayeshchart.base.baseComponents.BaseActivity;
import com.dimache.farapayeshchart.base.mvp.contract.Base;

import javax.inject.Inject;

/**
 * base of activities that are view (MVP)
 */

public abstract class MVPActivity<P extends Base.Presenter> extends BaseActivity implements Base.View {


    //presenter of view
    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        presenter = createPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }


    @Override
    protected void onStop() {
        super.onStop();
        presenter.deAttach();
    }

    @Override


    protected void onDestroy() {
        super.onDestroy();
        presenter.deAttach();
    }


//    public abstract P createPresenter();

  /*  @Override
    public void showLoading() {
        progress.animate().alpha(1f).setInterpolator(new AccelerateInterpolator());
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        progress.animate().alpha(0f).setInterpolator(new AccelerateInterpolator());
        progress.setVisibility(View.GONE);
    }*/

}
