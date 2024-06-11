package com.example.testapp.showcases.navigation.args

import com.example.testapp.showcases.ShowcaseItem
import com.example.testapp.showcases.ShowcasesViewModel
import com.example.testapp.showcases.navigation.args.from.ArgsNavigationFromDestination
import com.example.testapp.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.navigation.NavigationDestination

object ArgsNavigationShowcase : ShowcaseItem {

    override val label: String = "Navigation with arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ArgsNavigationFromDestination,
        ArgsNavigationToDestination
    )

}