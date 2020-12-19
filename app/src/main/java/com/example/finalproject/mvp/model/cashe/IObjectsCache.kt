package com.example.finalproject.mvp.model.cashe


import com.example.finalproject.mvp.model.entity.PictureObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IObjectsCache {
    fun getObject(id: Int): Single<PictureObject>
    fun putObject(users: PictureObject) : Completable
}