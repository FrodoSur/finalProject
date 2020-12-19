package com.example.finalproject.di.module

import android.widget.ImageView
import com.example.finalproject.mvp.model.cashe.image.IImageCache
import com.example.finalproject.mvp.model.cashe.image.room.RoomImageCache
import com.example.finalproject.mvp.model.entity.room.Database
import com.example.finalproject.mvp.model.image.IImageLoader
import com.example.finalproject.mvp.model.network.INetworkStatus
import com.example.finalproject.ui.App
import com.example.finalproject.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("cacheDir")
    @Singleton
    @Provides
    fun cacheDir(app: App): File = app.cacheDir

    @Singleton
    @Provides
    fun imageCache(database: Database, @Named("cacheDir") cacheDir: File): IImageCache = RoomImageCache(database, cacheDir)

    @Singleton
    @Provides
    fun imageLoader(cache: IImageCache, networkStatus: INetworkStatus): IImageLoader<ImageView> = GlideImageLoader(cache, networkStatus)

}