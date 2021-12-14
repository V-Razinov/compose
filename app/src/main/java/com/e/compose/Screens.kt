package com.e.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.e.compose.ui.SubScreen

sealed class Screens(
    val route: String,
    val content: @Composable (navController: NavController) -> Unit
) {
    object SubScreen : Screens(
        route = "sub_screen/{fromScreen}",
        content = { navController -> SubScreen(navController) }
    ) {
        const val ARG_FROM_SCREEN = "fromScreen"
        fun createRoute(fromScreen: String) = "sub_screen/$fromScreen"
    };

}
