package com.example.testapp.di

import com.example.testapp.di.datasource.ProvidesConfigSource
import com.example.testapp.di.datasource.ProvidesHttpSource
import com.example.testapp.di.state.ProvidesAppState
import com.example.testapp.di.state.ProvidesNavigationBarState
import com.example.testapp.di.state.ProvidesNavigationState
import com.example.testapp.di.state.ProvidesThemeState
import org.koin.core.context.startKoin

val koinDI = startKoin {
    printLogger()
    modules(
        ProvidesConfigSource,
        ProvidesHttpSource,
        ProvidesNavigationBarState,
        ProvidesNavigationState,
        ProvidesThemeState,
        ProvidesAppState
    )
}

inline fun <reified T : Any> get(): T = koinDI.koin.get<T>()