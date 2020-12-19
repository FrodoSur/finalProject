package com.example.finalproject.ui

import android.app.Application
import com.example.finalproject.di.AppComponent
import com.example.finalproject.di.item.ObjectSubcomponent
import com.example.finalproject.di.module.AppModule
import com.example.finalproject.di.repository.RepositorySubcomponent

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    var userSubcomponent: ObjectSubcomponent? = null
        private set

    var repositorySubcomponent: RepositorySubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun releaseUserSubcomponent() {
        userSubcomponent = null
    }

    fun initRepositorySubcomponent() = userSubcomponent?.repositorySubcomponent().also {
        repositorySubcomponent = it
    }

    fun releaseRepositorySubcomponent() {
        repositorySubcomponent = null
    }
}