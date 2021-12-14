package com.e.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import com.e.compose.Screens

@Composable
fun SubScreen(
    navController: NavController
) {
    val fromScreen = navController.currentBackStackEntry?.arguments?.getString(Screens.SubScreen.ARG_FROM_SCREEN) ?: "none"
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(text = "from screen: $fromScreen")
    }
}