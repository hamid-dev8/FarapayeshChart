package com.dimache.farapayeshchart.base.di;


import android.app.Application;

import com.dimache.farapayeshchart.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilders.class, RepositoryModule.class})
public interface AppComponent extends AndroidInjector<App> {
    void inject(App app);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
