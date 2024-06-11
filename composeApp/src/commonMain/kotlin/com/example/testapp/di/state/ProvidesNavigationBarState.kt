package com.example.testapp.di.state

import androidx.compose.runtime.Composable
import com.example.testapp.feature.navigation.NavigationBarPage
import com.example.testapp.feature.navigation.NavigationBarState
import com.example.testapp.feature.navigation.samples.a.NavigationADestination
import com.example.testapp.feature.navigation.samples.b.NavigationBDestination
import com.example.testapp.feature.navigation.samples.c.NavigationCDestination
import com.example.testapp.showcases.ShowcasesDestination
import org.koin.dsl.module
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationState
import shared.presentation.navigation.NavigationStrategy

val ProvidesNavigationBarState = module {
    single {
        NavigationBarState(
            pages = listOf(
                createPage(
                    navigationState = get(),
                    destination = ShowcasesDestination,
                    getActiveIcon = { AppIcons.school },
                    getInactiveIcon = { AppIcons.school },
                    getLabel = { "Showcases" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { AppIcons.wineBar },
                    getInactiveIcon = { AppIcons.wineBar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { AppIcons.news },
                    getInactiveIcon = { AppIcons.news },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationCDestination,
                    getActiveIcon = { AppIcons.coffee },
                    getInactiveIcon = { AppIcons.coffee },
                    getLabel = { "Page 3" }
                )
            ),
            allowedDestinations = setOf(
            ),
            restrictedDestinations = setOf(
            )
        )
    }
}

private fun <D> createPage(
    navigationState: NavigationState,
    destination: NavigationDestination<D>,
    getInactiveIcon: () -> AppIconModel,
    getActiveIcon: () -> AppIconModel,
    getLabel: @Composable () -> String?,
): NavigationBarPage {
    return NavigationBarPage(
        enabled = true,
        id = destination.id,
        getLabel = getLabel,
        alwaysShowLabel = false,
        getActiveIcon = getActiveIcon,
        getInactiveIcon = getInactiveIcon,
        onClick = { navigate(navigationState, destination) }
    )
}

private fun <D> navigate(
    navigationState: NavigationState,
    destination: NavigationDestination<D>
) {
    navigationState.onNext(
        destination = destination,
        strategy = NavigationStrategy.SingleInstance
    )
}