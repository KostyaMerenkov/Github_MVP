package ru.geekbrains.geekbrains_popular_libraries_kotlin.di

import javax.inject.Scope

//Пример своего скоупа на случай, если понадобится показать ученикам, как он устроен внутри
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SomeScope