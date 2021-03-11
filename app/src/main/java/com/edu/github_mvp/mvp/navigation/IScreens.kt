package com.edu.github_mvp.mvp.navigation

import com.edu.github_mvp.mvp.model.entity.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}