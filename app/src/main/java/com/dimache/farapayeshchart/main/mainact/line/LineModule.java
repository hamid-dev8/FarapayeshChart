package com.dimache.farapayeshchart.main.mainact.line;

import com.dimache.farapayeshchart.main.mainact.pie.PieContract;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class LineModule {

    @Provides
    static LineContract.View provideLineContractView(LineFragment view)
    {
        return view;
    }

    @Binds
    abstract LineContract.Presenter bindLinePresenter(LinePresenter presenter);

}
