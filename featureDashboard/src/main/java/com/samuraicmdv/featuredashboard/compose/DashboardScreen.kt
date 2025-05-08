package com.samuraicmdv.featuredashboard.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samuraicmdv.common.theme.MobiTheme
import com.samuraicmdv.featuredashboard.event.DashboardEvent
import com.samuraicmdv.featuredashboard.state.DailySaleState
import com.samuraicmdv.featuredashboard.state.DashboardScreenState
import com.samuraicmdv.ui.util.ThemePreviews

const val HOME_ROUTE = "home"
const val SALES_ROUTE = "sales"
const val SALES_HISTORY_ROUTE = "sales_history"
const val PROFILE_ROUTE = "profile"

@Composable
fun DashboardScreen(
    uiState: DashboardScreenState, // TODO Create a new UI state for main containing all the states
    modifier: Modifier = Modifier,
    callback: (DashboardEvent) -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(HOME_ROUTE) { HomeScreen() }
            composable(SALES_ROUTE) { DailySalesLedgeScreen(state = uiState.dailySaleState, callback = callback) }
            composable(SALES_HISTORY_ROUTE) { SalesHistoryScreen() }
            composable(PROFILE_ROUTE) { ProfileScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = HOME_ROUTE) },
            label = { Text("Home") },
            selected = navController.currentDestination?.route == HOME_ROUTE,
            onClick = {
                navController.navigate(HOME_ROUTE) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = SALES_ROUTE) },
            label = { Text("Sales") },
            selected = navController.currentDestination?.route == SALES_ROUTE,
            onClick = {
                navController.navigate(SALES_ROUTE) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = SALES_HISTORY_ROUTE) },
            label = { Text("History") },
            selected = navController.currentDestination?.route == SALES_HISTORY_ROUTE,
            onClick = {
                navController.navigate(SALES_HISTORY_ROUTE) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = PROFILE_ROUTE) },
            label = { Text("Profile") },
            selected = navController.currentDestination?.route == PROFILE_ROUTE,
            onClick = {
                navController.navigate(PROFILE_ROUTE) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
    }
}

// TODO When implemented, move to a separated files
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDC1111))
    ) {
        // Your HomeScreen content
    }
}

// TODO When implemented, move to a separated files
@Composable
fun SalesHistoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF9800))
    ) {
        // Your HomeScreen content
    }
}

// TODO When implemented, move to a separated files
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1100FF))
    ) {
        // Your HomeScreen content
    }
}

// TODO When implemented, move to a separated files
@ThemePreviews
@Composable
fun PreviewMainScreen() {
    MobiTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            DashboardScreen(
                uiState = DashboardScreenState(
                    productCategoriesState = null,
                    dailySaleState = DailySaleState()
                ),
                callback = {}
            )
        }
    }
}