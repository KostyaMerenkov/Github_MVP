package com.edu.github_mvp.mvp.presenter

import com.edu.github_mvp.mvp.navigation.IScreens
import com.edu.github_mvp.mvp.view.MainView
import com.edu.github_mvp.mvp.view.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val router: Router, private val screens: IScreens) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        router.replaceScreen(screens.user(user))
    }

    fun backClicked() {
        router.exit()
    }
}