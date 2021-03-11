package com.edu.github_mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.github_mvp.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.edu.github_mvp.databinding.FragmentUsersBinding
import com.edu.github_mvp.mvp.model.GithubUsersRepo
import com.edu.github_mvp.mvp.model.entity.GithubUser
import com.edu.github_mvp.mvp.navigation.IScreens
import com.edu.github_mvp.mvp.presenter.UserPresenter
import com.edu.github_mvp.mvp.presenter.UsersPresenter
import com.edu.github_mvp.mvp.view.UsersView
import com.edu.github_mvp.ui.App
import com.edu.github_mvp.ui.BackClickListener
import com.edu.github_mvp.ui.adapter.UsersRVAdapter
import com.github.terrakok.cicerone.Screen

class UserFragment : MvpAppCompatFragment() {

//    private val presenter by moxyPresenter {
//        UserPresenter(App.instance.router, )
//    }

    private var vb: FragmentUserBinding? = null
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb.let {
            vb = it
        }
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

//    override fun backPressed() = presenter.backClick()

}