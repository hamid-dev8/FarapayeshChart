package com.dimache.farapayeshchart.base.mvp.contract;

/**
 * Created by User on 11/28/2017.
 */

public interface Base
{
    public interface View {

    }

    public interface DataView extends View
    {
        void showLoading();
        void dismissLoading();
        void showError();
        void showEmpty();
        void dissmissViewLoader();
    }

    public interface NetView extends DataView
    {
        void connected();
        void disConnected();
    }


    public interface Presenter {
        public void subscribe();
        public void unSubscribe();
        public void deAttach();
    }
}
