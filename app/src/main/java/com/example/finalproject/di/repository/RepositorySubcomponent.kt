package com.example.finalproject.di.repository

import android.widget.ImageView
import com.example.finalproject.di.repository.module.RepositoryModule
import com.example.finalproject.mvp.model.image.IImageLoader
import com.example.finalproject.mvp.presenter.ObjectPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class,

    ]
)
interface RepositorySubcomponent {
    fun inject(objectPresenter: ObjectPresenter)

    fun inject(imageLoader: IImageLoader<ImageView>)
}