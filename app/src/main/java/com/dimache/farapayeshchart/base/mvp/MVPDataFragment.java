package com.dimache.farapayeshchart.base.mvp;

import com.dimache.farapayeshchart.base.baseComponents.views.EmptyFrame;
import com.dimache.farapayeshchart.base.baseComponents.views.ErrorFrame;
import com.dimache.farapayeshchart.base.baseComponents.views.ProgressFrame;
import com.dimache.farapayeshchart.base.mvp.contract.Base;

/**
 * Created by User on 1/14/2018.
 */

public abstract class MVPDataFragment<P extends Base.Presenter> extends MVPFragment<P> implements Base.DataView
{

    ProgressFrame progress;
    ErrorFrame error;
    EmptyFrame empty;

    public void setProgress(ProgressFrame progress) {
        this.progress = progress;
    }

    public void setError(ErrorFrame error) {
        this.error = error;
    }

    public void setEmpty(EmptyFrame empty) {
        this.empty = empty;
    }

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

    @Override
    public void dismissLoading() {
        if (progress != null)
            progress.dismiss();
    }

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
