package com.dimache.farapayeshchart.main.mainact;

import com.dimache.farapayeshchart.main.mainact.pie.PieFragment;
import com.dimache.farapayeshchart.main.mainact.pie.PieModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainProvider
{
    @ContributesAndroidInjector(modules = {PieModule.class})
    abstract PieFragment providePieFragment();
}
