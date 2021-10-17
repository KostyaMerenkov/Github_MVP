package com.edu.github_mvp

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserView
import org.junit.Before
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserPresenter

class UserPresenterUnitTest {

    private lateinit var presenter : UserPresenter
    private lateinit var repositoriesListPresenter : UserPresenter.RepositoriesListPresenter

    @Mock
    private lateinit var view : UserView
    private val uiScheduler = AndroidSchedulers.mainThread()
    @Mock
    private lateinit var repositoriesRepo: IGithubRepositoriesRepo
    @Mock
    private lateinit var router: Router
    @Mock
    private lateinit var user: GithubUser
    @Mock
    private lateinit var screens: IScreens

    @Before
    fun Setup() {
        MockitoAnnotations.initMocks(this)
        presenter = UserPresenter(uiScheduler, repositoriesRepo, router, user, screens)
    }

    @Test
    fun OnFirstViewAttachedTest() { //testFails
        `when`(presenter.attachView(view)).then { view.init(); presenter.loadData() }
        `when`(presenter.loadData()).then { repositoriesRepo.getRepositories(user) }
        //`when`(repositoriesRepo.getRepositories(user)).thenReturn(<List<GithubRepository>)
        //presenter.attachView(view)
        verify(view, times(1)).init()
        verify(presenter, times(1)).loadData()
    }

    @Test
    fun RepositoriesListPresenterTest() {
        `when`(repositoriesListPresenter.getCount()).thenReturn(anyInt())
        //`when`(uiScheduler.getMainLooper())
        assertNotNull(presenter.repositoriesListPresenter.getCount())

    }

    @Test
    fun LoadDataTest() {
        presenter.loadData()
        verify(repositoriesRepo, times(1)).getRepositories(user)

    }
}
