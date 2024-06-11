package com.example.testapp.showcases.datasource.http.basic

import com.example.testapp.showcases.ShowcaseItem
import com.example.testapp.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicHttpShowcase : ShowcaseItem {

    override val label: String = "Basic Http Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(BasicHttpDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicHttpDestination
    )

}