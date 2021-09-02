package com.e.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.LightGray,
                    elevation = 0.dp
                ) {
                    Text(
                        text = " Item $index",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = true),
                                onClick = { },
                            ),
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(
    scope: CoroutineScope,
    drawerState: DrawerState
) = TopAppBar(
    backgroundColor = Color.Blue
) {
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Связной",
        color = Color.White,
        fontSize = 24.sp
    )
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
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