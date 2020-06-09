package com.dimache.farapayeshchart.main;


import com.dimache.farapayeshchart.base.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
