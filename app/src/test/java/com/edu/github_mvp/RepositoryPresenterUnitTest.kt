package com.edu.github_mvp

import moxy.MvpPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepositoryPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView

class RepositoryPresenterUnitTest {

    private lateinit var presenter : RepositoryPresenter
    @Mock
    private lateinit var repository : GithubRepository
    @Mock
    private lateinit var view : RepositoryView

    @Before
    fun Setup() {
        MockitoAnnotations.initMocks(this)
        //presenter.attachView(view)
    }

    @Test
    fun `On First View Attached Test`() {

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