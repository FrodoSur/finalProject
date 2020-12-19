package com.example.finalproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.finalproject.R
import com.kotlin.museamproject.R
import com.example.finalproject.mvp.model.entity.PictureObject
import com.example.finalproject.mvp.model.image.IImageLoader
import com.example.finalproject.mvp.presenter.ObjectPresenter
import com.example.finalproject.mvp.view.ObjectView
import com.example.finalproject.ui.App
import com.example.finalproject.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_object.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ObjectFragment : MvpAppCompatFragment(), ObjectView, BackButtonListener {

    companion object {
        private const val REPOSITORY_ARG = "repository"

        fun newInstance(repository: PictureObject) = ObjectFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }


    val presenter: ObjectPresenter by moxyPresenter {
        val repositorySubcomponent = App.instance.initRepositorySubcomponent()
        val repository = arguments?.getParcelable<PictureObject>(REPOSITORY_ARG) as PictureObject
        ObjectPresenter(repository).apply {
            repositorySubcomponent?.inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_object, null)

    override fun init() {

    }

    override fun setTitle(text: String) {
        title.text = text
    }

    override fun loadImage(url: String, imageLoader: IImageLoader<ImageView>) {
        imageLoader.loadInto(url, image)
    }

    override fun setAuthor(text: String) {
        author.text = text
    }


    override fun backPressed() = presenter.backPressed()

    override fun onDestroy() {
        super.onDestroy()
        System.out.println("onDestroy")
    }
}