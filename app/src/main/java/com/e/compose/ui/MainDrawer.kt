package com.e.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainDrawer(
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Header(scope, drawerState)
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) { index ->
                Text(
                    text = " Item $index",
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .background(Color.LightGray, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun Header(
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    //replace with TopAppBar?
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color.Blue)
            .padding(start = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart),
            text = "Связной",
            color = Color.White,
            fontSize = 24.sp
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            onClick = { scope.launch { drawerState.close() } }
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                imageVector = Icons.Rounded.Close,
                contentDescription = "close drawer",
                tint = Color.White,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    )
    MainDrawer(
        scope = scope,
        drawerState = scaffoldState.drawerState
    )
}