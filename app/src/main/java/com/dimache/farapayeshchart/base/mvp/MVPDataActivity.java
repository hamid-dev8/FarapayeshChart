package com.dimache.farapayeshchart.base.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dimache.farapayeshchart.base.baseComponents.views.EmptyFrame;
import com.dimache.farapayeshchart.base.baseComponents.views.ErrorFrame;
import com.dimache.farapayeshchart.base.baseComponents.views.ProgressFrame;
import com.dimache.farapayeshchart.base.mvp.contract.Base;

/**
 * Created by User on 1/14/2018.
 */

public abstract class MVPDataActivity<P extends Base.Presenter> extends MVPActivity<P> implements Base.DataView
{

    /*views are implimented #com.dimache.base.baseComponents.views.DataLoaderView */
    //progress view
    ProgressFrame progress;
    //error view
    ErrorFrame error;
    //empty view
    EmptyFrame empty;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void setProgress(ProgressFrame progress) {
        this.progress = progress;
    }

    public void setError(ErrorFrame error) {
        this.error = error;
    }

    public void setEmpty(EmptyFrame empty) {
        this.empty = empty;
    }

    /*
     *show progress view if is available by #setProgress
     */
    @Override
    public void showLoading() {
        if (progress == null)
            return;
        progress.show();
        if (error != null)
            error.dismiss();
        if (empty != null)
            empty.dismiss();
    }
    /*
    *hide progress view if is available by #setProgress
    */
    @Override
    public void dismissLoading() {
        if (progress != null)
            progress.dismiss();
    }

    /*
     *show error view if is available by #setError
     */
    @Override
    public void showError() {
        if (error == null)
            return;
        error.show();
        if (progress != null)
            progress.dismiss();
        if (empty != null)
            empty.dismiss();
    }

    /*
     *show empty view if is available by #setEmpty
     */
    @Override
    public void showEmpty() {
        if (empty == null)
            return;
        empty.show();
        if (error != null)
            error.dismiss();
        if (progress != null)
            progress.dismiss();
    }
    /*
     *hide ALL view if is available
     */

    @Override
    public void dissmissViewLoader() {
        if (progress != null)
            progress.dismiss();
        if (empty != null)
            empty.dismiss();
        if (error != null)
            error.dismiss();
    }
}
