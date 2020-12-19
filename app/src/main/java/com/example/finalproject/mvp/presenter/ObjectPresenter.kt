package com.example.finalproject.mvp.presenter

import android.widget.ImageView
import com.example.finalproject.mvp.model.entity.PictureObject
import com.example.finalproject.mvp.model.image.IImageLoader
import com.example.finalproject.mvp.view.ObjectView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ObjectPresenter(val pictureObject: PictureObject) : MvpPresenter<ObjectView>() {

    @Inject lateinit var router: Router

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setAuthor(pictureObject.artistDisplayName ?: "")
        viewState.setTitle(pictureObject.title ?: "")
        viewState.loadImage((pictureObject.primaryImage ?: 0).toString(), imageLoader)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("onDestroy presenter")
    }
}