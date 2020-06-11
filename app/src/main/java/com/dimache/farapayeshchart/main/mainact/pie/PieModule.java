package com.dimache.farapayeshchart.main.mainact.pie;


import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PieModule {


    @Provides
    static PieContract.View provideContractView(PieFragment view) {
        return view;
    }

    @Binds
    abstract PieContract.Presenter bindPiePresenter(PiePresenter presenter);

}
