package com.edu.github_mvp

import android.view.View
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.internal.matchers.Not
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepositoryPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView

class RepositoryPresenterUnitTest {

    private lateinit var presenter : RepositoryPresenter
    @Mock
    private lateinit var repository : GithubRepository
    @Mock
    private lateinit var router : Router
    @Mock
    private lateinit var view : RepositoryView

    @Before
    fun Setup() {
        MockitoAnnotations.initMocks(this)
        presenter = RepositoryPresenter(router, repository)
    }

    @Test
    fun OnFirstViewAttachedTest() {
        val mvpPresenter = object : MvpPresenter<RepositoryView>() {
            public override fun onFirstViewAttach() {
                super.onFirstViewAttach()
                view.init()
                view.setId(repository.id ?: "")
                view.setTitle(repository.name ?: "")
                view.setForksCount(repository.forksCount?.toString() ?: "")
            }
        }
        presenter.attachView(view)
        verify(view, times(1)).init()
        verify(view, times(1)).setId(anyString())
        verify(view, times(1)).setTitle(anyString())
        verify(view, times(1)).setForksCount(anyString())
    }
}