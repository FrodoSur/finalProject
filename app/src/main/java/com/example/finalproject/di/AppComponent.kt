package com.example.finalproject.di

import com.example.finalproject.di.item.ObjectSubcomponent
import com.example.finalproject.di.module.*
import com.example.finalproject.mvp.presenter.MainPresenter
import com.example.finalproject.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DatabaseModule::class,
        CiceroneModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun userSubcomponent() : ObjectSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}