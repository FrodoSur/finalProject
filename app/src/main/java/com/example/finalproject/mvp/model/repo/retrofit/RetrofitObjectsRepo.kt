package com.example.finalproject.mvp.model.repo.retrofit


import com.example.finalproject.mvp.model.api.IDataSource
import com.example.finalproject.mvp.model.cashe.IObjectsCache
import com.example.finalproject.mvp.model.network.INetworkStatus
import com.example.finalproject.mvp.model.repo.IObjectsRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitObjectsRepo(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IObjectsCache) :
    IObjectsRepo {

    override fun getObject(id: Int) = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
                api.getObject(id).flatMap { users ->
                    cache.putObject(users).toSingleDefault(users)
                }
        } else {
            cache.getObject(id)
        }
    }.subscribeOn(Schedulers.io())
}