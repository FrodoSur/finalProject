package com.example.finalproject.mvp.view

import android.widget.ImageView
import com.example.finalproject.mvp.model.image.IImageLoader
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ObjectView : MvpView {
    fun init()
    fun setTitle(text: String)
    fun setAuthor(text: String)
    fun loadImage(url: String, imageLoader: IImageLoader<ImageView>)
}