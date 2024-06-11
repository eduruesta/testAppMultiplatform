package com.example.testapp.di.state

import com.example.testapp.AppNavigationRouter
import com.example.testapp.AppState
import org.koin.dsl.module

val ProvidesAppState = module {
    single { AppState() }
    single { AppNavigationRouter() }
}