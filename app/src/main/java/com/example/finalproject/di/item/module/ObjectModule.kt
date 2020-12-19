package com.example.finalproject.di.item.module


import com.example.finalproject.di.item.ObjectScope
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
open class ObjectModule {

    @Provides
    fun usersCache(database: Database): IObjectsCache {
        return RoomObjectsCache(database)
    }


    @ObjectScope
    @Provides
    open fun usersRepo(api: IDataSource, networkStatus: INetworkStatus, cache: IObjectsCache): IObjectsRepo {
        return RetrofitObjectsRepo(api, networkStatus, cache)
    }
}