package com.edu.github_mvp.mvp.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val login: String
) : Parcelable