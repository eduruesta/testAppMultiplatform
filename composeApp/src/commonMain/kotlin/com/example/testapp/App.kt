package com.example.testapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.testapp.di.get
import com.example.testapp.showcases.ShowcasesViewModel
import com.example.testapp.showcases.datasource.http.basic.BasicHttpViewModel
import com.example.testapp.showcases.navigation.args.from.ArgsNavigationFromViewModel
import com.example.testapp.showcases.navigation.args.to.ArgsNavigationToViewModel
import com.example.testapp.showcases.navigation.no_args.from.NoArgsNavigationFromViewModel
import com.example.testapp.showcases.navigation.no_args.to.NoArgsNavigationToViewModel
import com.example.testapp.ui.screen.template.TemplateViewModel
import com.example.testapp.ui.screen.template_no_args.TemplateNoArgsViewModel
import com.example.testapp.ui.theme.AppThemeProvider
import com.example.testapp.ui.theme.AppThemeViewModel
import com.example.testapp.feature.navigation.NavigationBarViewModel
import com.example.testapp.feature.navigation.samples.a.NavigationAViewModel
import com.example.testapp.feature.navigation.samples.b.NavigationBViewModel
import com.example.testapp.feature.navigation.samples.c.NavigationCViewModel
import shared.presentation.ViewModelProvider

/**
 * Root of the application.
 */
@Composable
fun App() = ViewModelProvider(remember { AppViewModelFactory }) {
    AppThemeProvider {
        AppScreen()
    }
}

private val AppViewModelFactory = viewModelFactory {
    initializer { AppViewModel(get(), get(), get()) }
    initializer { AppThemeViewModel(get()) }
    initializer { TemplateNoArgsViewModel(get()) }
    initializer { TemplateViewModel(get()) }
    initializer { ShowcasesViewModel(get()) }
    initializer { BasicHttpViewModel(get(), get()) }
    initializer { NavigationAViewModel() }
    initializer { NavigationBViewModel() }
    initializer { NavigationCViewModel() }
    initializer { NavigationBarViewModel(get(), get()) }
    initializer { NoArgsNavigationFromViewModel(get()) }
    initializer { NoArgsNavigationToViewModel(get()) }
    initializer { ArgsNavigationFromViewModel(get()) }
    initializer { ArgsNavigationToViewModel(get()) }
}