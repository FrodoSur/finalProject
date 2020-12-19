package com.example.finalproject.mvp.presenter


import com.example.finalproject.mvp.view.MainView
import com.example.finalproject.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.ObjectsScreen())
    }

    fun backClicked() {
        router.exit()
    }
}
