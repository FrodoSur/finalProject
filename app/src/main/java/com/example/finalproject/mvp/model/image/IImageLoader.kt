package com.example.finalproject.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}