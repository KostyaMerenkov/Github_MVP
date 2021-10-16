package ru.geekbrains.geekbrains_popular_libraries_kotlin.di

import javax.inject.Qualifier

//Пример своего квалифаера на случай, если понадобится показать ученикам, как он устроен внутри.
//Аналогичен Named, но с интом вместо строки. Как гласит название - можно использовать для версионирования чего-либо
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Versioned(val version: Int)