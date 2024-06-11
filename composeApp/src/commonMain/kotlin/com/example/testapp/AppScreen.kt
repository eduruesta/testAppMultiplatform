package com.example.testapp

import androidx.compose.runtime.Composable
import com.example.testapp.feature.navigation.NavigationBarProvider
import com.example.testapp.feature.navigation.BottomProvider
import shared.presentation.navigation.rememberNavigationContext
import shared.presentation.provideViewModel
import shared.design.container.AppScaffold

/**
 * The main screen of the application.
 */
@Composable
fun AppScreen() {
    val viewModel: AppViewModel = provideViewModel()
    val navigationState = viewModel.navigationState
    val navigationContext = rememberNavigationContext(navigationState)
    NavigationBarProvider {
        AppScaffold(
            navigationContext = navigationContext,
            bottomBar = { BottomProvider() }
        )
    }
}