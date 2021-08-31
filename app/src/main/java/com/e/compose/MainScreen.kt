package com.e.compose

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.e.compose.ui.MainDrawer
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    val ctx = LocalContext.current
    Scaffold(
        topBar = {
            TopBar(
                onDrawerIconClick = { scope.launch { scaffoldState.drawerState.open() } },
                onSearchClick = {
                    Toast.makeText(ctx, "Search", Toast.LENGTH_SHORT).show()
                }
            )
        },
        drawerContent = {
            MainDrawer(
                scope = scope,
                drawerState = scaffoldState.drawerState
            )
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun TopBar(
    onDrawerIconClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color.Blue
    ) {
        IconButton(onClick = onDrawerIconClick) {
            Icon(
                imageVector = Icons.Rounded.Apps,
                contentDescription = "open drawer",
                tint = Color.White
            )
        }
        Text(
            text = "Связной",
            color = Color.White,
            fontSize = 24.sp
        )
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = onSearchClick
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color.White,
                )
            }
        }
    }
}