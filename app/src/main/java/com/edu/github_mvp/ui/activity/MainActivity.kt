package com.edu.github_mvp.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import com.edu.github_mvp.R
import com.edu.github_mvp.databinding.ActivityMainBinding
import com.edu.github_mvp.mvp.presenter.MainPresenter
import com.edu.github_mvp.mvp.view.MainView
import com.edu.github_mvp.ui.App
import com.edu.github_mvp.ui.BackClickListener
import com.edu.github_mvp.ui.adapter.UsersRVAdapter
import com.edu.github_mvp.ui.navigation.AndroidScreens

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackClickListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }

}