package com.edu.github_mvp.mvp.model

import com.edu.github_mvp.mvp.model.entity.GithubUser

class GithubUsersRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): List<GithubUser> {
        return users
    }
}