package com.example.testapp.di.datasource

import com.example.testapp.datasource.config.AppConfigSource
import shared.data.datasource.config.ConfigSource
import org.koin.dsl.bind
import org.koin.dsl.module

val ProvidesConfigSource = module {
    single { AppConfigSource() }.bind(ConfigSource::class)
}