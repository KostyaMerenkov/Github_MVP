package com.edu.github_mvp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.edu.github_mvp.mvp.model.GithubUsersRepo
import com.edu.github_mvp.mvp.model.entity.GithubUser
import com.edu.github_mvp.mvp.presenter.list.IUsersListPresenter
import com.edu.github_mvp.mvp.view.UsersView
import com.edu.github_mvp.mvp.view.list.IUserItemView

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUsersListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { view ->
            val user = usersListPresenter.users[view.pos]
            //router.navigateTo(screens.user(user))
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.clear()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}