package com.dimache.farapayeshchart.main.mainact.pie;

import com.dimache.farapayeshchart.base.di.Repository;
import com.dimache.farapayeshchart.base.mvp.MVPNetPresenter;
import com.dimache.farapayeshchart.base.mvp.MVPPresenter;
import com.dimache.farapayeshchart.base.reactive.RepositoryObserver;
import com.dimache.farapayeshchart.base.reactive.RxSchedulers;
import com.dimache.farapayeshchart.main.data.model.TotalInfected;
import com.dimache.farapayeshchart.main.data.repository.TotalInfectedRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PiePresenter extends MVPPresenter<PieContract.View> implements PieContract.Presenter {


    @Repository
    TotalInfectedRepository repository;

    @Inject
    public PiePresenter(PieContract.View view , @Repository TotalInfectedRepository repository) {
        super(view);
        this.repository = repository;
    }

    @Override
    public void getTotals() {
        view.showLoading();
        repository.getTotalInfected().subscribeOn(RxSchedulers.io())
                .observeOn(RxSchedulers.main())
                .subscribe(new RepositoryObserver<List<TotalInfected>>() {
                    @Override
                    public void onResponse(List<TotalInfected> totalInfecteds) {
                        view.showTotals(totalInfecteds);
                    }

                    @Override
                    public void onNotFound() {
                        view.showEmpty();
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }
                });

    }
}
