package com.example.finalproject.di.module


import com.example.finalproject.mvp.model.api.IDataSource
import com.example.finalproject.mvp.model.cashe.IObjectsCache
import com.example.finalproject.mvp.model.network.INetworkStatus
import com.example.finalproject.mvp.model.repo.IObjectsRepo
import com.example.finalproject.mvp.model.repo.retrofit.RetrofitObjectsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun objectRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo =
        RetrofitObjectsRepo(api, networkStatus, cache)

}