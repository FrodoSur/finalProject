package com.example.finalproject.mvp.model.repo


import com.example.finalproject.mvp.model.entity.PictureObject
import io.reactivex.rxjava3.core.Single

interface IObjectsRepo {
    fun getObject(id : Int): Single<PictureObject>
}