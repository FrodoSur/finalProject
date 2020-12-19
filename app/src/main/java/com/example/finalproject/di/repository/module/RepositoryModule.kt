package com.example.finalproject.di.repository.module

import com.example.finalproject.di.repository.RepositoryScope
import com.example.finalproject.mvp.model.api.IDataSource
import com.example.finalproject.mvp.model.cashe.IObjectsCache
import com.example.finalproject.mvp.model.cashe.room.RoomObjectsCache
import com.example.finalproject.mvp.model.entity.room.Database
import com.example.finalproject.mvp.model.network.INetworkStatus
import com.example.finalproject.mvp.model.repo.IObjectsRepo
import com.example.finalproject.mvp.model.repo.retrofit.RetrofitObjectsRepo
import dagger.Module
import dagger.Provides

@Module
open class RepositoryModule {

    @Provides
    fun repositoriesCache(database: Database): IObjectsCache {
        return RoomObjectsCache(database)
    }

    @RepositoryScope
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo {
        return RetrofitObjectsRepo(api, networkStatus, cache)
    }
}