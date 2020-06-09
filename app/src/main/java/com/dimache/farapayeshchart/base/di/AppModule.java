package com.dimache.farapayeshchart.base.di;


import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module()
public abstract class AppModule
{
    @Provides
    @ApplicationContext
    static Context provideContext(Application application)
    {
        return application.getApplicationContext();
    }
}
