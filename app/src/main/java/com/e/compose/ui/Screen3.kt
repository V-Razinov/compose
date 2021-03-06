package com.e.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.e.compose.Screens

@Composable
fun Screen3(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Button(
            onClick = { navController.navigate(Screens.SubScreen.createRoute("screen 3")) }
        ) {
            Text(text = "screen 3")
        }
    }
}