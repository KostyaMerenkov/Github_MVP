package com.edu.github_mvp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.edu.github_mvp.mvp.navigation.IScreens
import com.edu.github_mvp.mvp.view.MainView

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }

}