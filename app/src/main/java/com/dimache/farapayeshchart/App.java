package com.dimache.farapayeshchart;

import android.content.Context;

import com.dimache.farapayeshchart.base.di.ApplicationContext;
import com.dimache.farapayeshchart.base.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication
{
    @Inject
    @ApplicationContext
    Context context;

    private static Context appContext;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();


    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }


    public static Context getAppContext(){
        return App.appContext;
    }
}
