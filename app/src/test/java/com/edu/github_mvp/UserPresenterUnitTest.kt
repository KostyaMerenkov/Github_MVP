package com.edu.github_mvp

import moxy.MvpPresenter
import org.junit.Test
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserView

package com.edu.github_mvp;

import org.junit.Before;

import org.mockito.Mock;


import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserPresenter;

public class UserPresenterUnitTest {

    private lateinit var presenter : UserPresenter
    @Mock
    private lateinit var user : GithubUser
    @Mock
    private lateinit var view : UserView
    @Mock
    private lateinit var repositoriesRepo : IGithubRepositoriesRepo

    @Before
    fun Setup() {
        MockitoAnnotations.initMocks(this)
        //presenter.attachView(view)
    }

    @Test
    fun OnFirstViewAttachedTest() {
        presenter.
        val mvpPresenter = object : MvpPresenter<RepositoryView>() {
            override fun onFirstViewAttach() {
                super.onFirstViewAttach()
                viewState.init()
                viewState.setId(repository.id ?: "")
                viewState.setTitle(repository.name ?: "")
                viewState.setForksCount(repository.forksCount?.toString() ?: "")
            }
        }

        presenter.attachView(view)
        verify(view, times(1)).init()
        verify(view, times(1)).setId(anyString())
        verify(view, times(1)).setTitle(anyString())
        verify(view, times(1)).setForksCount(anyString())
    }
}
