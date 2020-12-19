package com.example.finalproject.navigation


import com.example.finalproject.mvp.model.entity.PictureObject
import com.example.finalproject.ui.fragment.ObjectFragment
import com.example.finalproject.ui.fragment.ObjectsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class ObjectsScreen() : SupportAppScreen() {
        override fun getFragment() = ObjectsFragment.newInstance()
    }

    class ObjectScreen(val pictureObject: PictureObject) : SupportAppScreen() {
        override fun getFragment() = ObjectFragment.newInstance(pictureObject)
    }

}