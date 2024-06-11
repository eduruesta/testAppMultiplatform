package com.example.testapp.showcases.navigation.no_args

import com.example.testapp.showcases.ShowcaseItem
import com.example.testapp.showcases.ShowcasesViewModel
import com.example.testapp.showcases.navigation.no_args.from.NoArgsNavigationFromDestination
import com.example.testapp.showcases.navigation.no_args.to.NoArgsNavigationToDestination
import shared.presentation.navigation.NavigationDestination

object NoArgsNavigationShowcase : ShowcaseItem {

    override val label: String = "Navigation without arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(NoArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        NoArgsNavigationFromDestination,
        NoArgsNavigationToDestination
    )

}