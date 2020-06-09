package com.dimache.farapayeshchart.base.di;


import com.dimache.farapayeshchart.main.MainActivity;
import com.dimache.farapayeshchart.main.MainModule;
import com.dimache.farapayeshchart.main.MainProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilders {

     /*@ContributesAndroidInjector(modules = {BookmarkActivityModule.class, BookMarkProvider.class})
    abstract BookmarkActivity bindBookmarkActivity();*/


    @ContributesAndroidInjector(modules = {MainModule.class, MainProvider.class})
    abstract MainActivity bindMainActivity();
}
