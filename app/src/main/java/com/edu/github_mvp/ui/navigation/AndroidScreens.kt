package com.edu.github_mvp.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.edu.github_mvp.mvp.navigation.IScreens
import com.edu.github_mvp.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}