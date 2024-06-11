package com.example.testapp.di.state

import com.example.testapp.showcases.ShowcasesDestination
import com.example.testapp.ui.screen.template.TemplateDestination
import com.example.testapp.ui.screen.template_no_args.TemplateNoArgsDestination
import com.example.testapp.feature.navigation.samples.a.NavigationADestination
import com.example.testapp.feature.navigation.samples.b.NavigationBDestination
import com.example.testapp.feature.navigation.samples.c.NavigationCDestination
import org.koin.dsl.module
import shared.presentation.navigation.NavigationState

val ProvidesNavigationState = module {
    single {
        NavigationState(
            destinations = listOf(
                ShowcasesDestination,
                TemplateDestination,
                TemplateNoArgsDestination,
                NavigationADestination,
                NavigationBDestination,
                NavigationCDestination,
            )
        )
    }
}