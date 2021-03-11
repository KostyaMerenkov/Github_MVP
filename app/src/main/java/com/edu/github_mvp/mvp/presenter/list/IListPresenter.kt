package com.edu.github_mvp.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}