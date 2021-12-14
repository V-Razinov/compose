package com.e.compose

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.e.compose.ui.Screen1
import com.e.compose.ui.Screen2
import com.e.compose.ui.Screen3
import com.e.compose.ui.Screen4

enum class RootScreens(
    val bottomNavIcon: @Composable () -> Unit,
    val route: String,
    val content: @Composable (navController: NavController) -> Unit
) {
    SCREEN_1(
        bottomNavIcon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = "screen_1") },
        route = "screen_1",
        content = { navController -> Screen1(navController = navController) }
    ),
    SCREEN_2(
        bottomNavIcon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = "screen_2") },
        route = "screen_2",
        content = { navController -> Screen2(navController = navController) }
    ),
    SCREEN_3(
        bottomNavIcon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = "screen_3") },
        route = "screen_3",
        content = { navController -> Screen3(navController = navController) }
    ),
    SCREEN_4(
        bottomNavIcon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = "screen_4") },
        route = "screen_4",
        content = { navController -> Screen4(navController = navController) }
    )
}