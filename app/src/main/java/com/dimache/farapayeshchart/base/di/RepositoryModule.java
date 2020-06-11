package com.dimache.farapayeshchart.base.di;


import com.dimache.farapayeshchart.main.data.remote.TotalInfectedRemote;
import com.dimache.farapayeshchart.main.data.repository.TotalInfectedRepository;
import com.dimache.farapayeshchart.main.data.repository.imp.TotalInfectedRepositoryImp;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {


    /*remote*/
    @Remote
    @Binds
    abstract TotalInfectedRepository provideTotalInfectedRemote(TotalInfectedRemote remote);
    /*remote*/


    /*repositoryIMP*/
    @Repository
    @Binds
    @Singleton
    abstract TotalInfectedRepository provideTotalInfectedRepoImp(TotalInfectedRepositoryImp imp);
    /*repositoryIMP*/
}
