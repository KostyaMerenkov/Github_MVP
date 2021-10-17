package com.edu.github_mvp

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import moxy.MvpPresenter
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepositoryPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView

class MainPresenterUnitTest {

    private lateinit var presenter : MainPresenter
    @Mock
    private lateinit var screens: IScreens
    @Mock
    private lateinit var router : Router
    @Mock
    private lateinit var view : MainView

    @Before
    fun Setup() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(router, screens)
    }

    @Test
    fun OnFirstViewAttachedTest() {
        val screen: Screen = mock(Screen::class.java)
        `when`(screens.users()).thenReturn(screen)
        assertNotNull(screens.users())
        presenter.attachView(view)
        Mockito.verify(router, Mockito.times(1)).replaceScreen(screens.users())
    }
}