package com.example.testapp.showcases

import com.example.testapp.showcases.datasource.http.basic.BasicHttpShowcase
import com.example.testapp.showcases.navigation.args.ArgsNavigationShowcase
import com.example.testapp.showcases.navigation.no_args.NoArgsNavigationShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        ShowcaseItemGroup("Datasource :: Http"),
        BasicHttpShowcase,
    )

}