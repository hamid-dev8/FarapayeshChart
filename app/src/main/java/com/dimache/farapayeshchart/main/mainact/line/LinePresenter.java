package com.dimache.farapayeshchart.main.mainact.line;

import com.dimache.farapayeshchart.base.di.Repository;
import com.dimache.farapayeshchart.base.mvp.MVPPresenter;
import com.dimache.farapayeshchart.base.reactive.RepositoryObserver;
import com.dimache.farapayeshchart.base.reactive.RxSchedulers;
import com.dimache.farapayeshchart.main.data.model.CountriesInfected;
import com.dimache.farapayeshchart.main.data.model.CountriesMap;
import com.dimache.farapayeshchart.main.data.repository.CountriesInfectedRepository;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class LinePresenter extends MVPPresenter<LineContract.View> implements LineContract.Presenter {

    @Repository
    CountriesInfectedRepository repository;


    @Inject
    public LinePresenter(LineContract.View view , @Repository CountriesInfectedRepository repository) {
        super(view);

        this.repository = repository;
    }

    @Override
    public void getOnCountries() {
        view.showLoading();
        repository.getCountriesInfected().subscribeOn(RxSchedulers.io())
                .observeOn(RxSchedulers.main())
                .subscribe(new RepositoryObserver<CountriesMap>() {
                    @Override
                    public void onResponse(CountriesMap countriesInfecteds) {
                        view.showOnCountries(countriesInfecteds);
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
