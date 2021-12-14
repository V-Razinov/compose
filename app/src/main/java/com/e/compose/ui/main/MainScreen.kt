package com.e.compose.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.e.compose.RootScreens
import com.e.compose.Screens


@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val scaffoldState = rememberScaffoldState()

    val navController = rememberNavController()
    val rootScreens = RootScreens.values()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar {
                rootScreens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { screen.bottomNavIcon() },
                        selected = true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPaddings ->
        NavHost(
            navController = navController,
            startDestination = RootScreens.SCREEN_1.route,
            modifier = Modifier.padding(innerPaddings)
        ) {
            rootScreens.forEach { screen ->
                composable(screen.route) { screen.content(navController) }
            }
            Screens::class.nestedClasses
                .map { it.objectInstance as Screens }
                .forEach { screen ->
                    composable(screen.route) { screen.content(navController) }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}