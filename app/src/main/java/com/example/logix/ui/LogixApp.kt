// LogixApp.kt
package com.example.logix.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.logix.data.LogixActivityData
import com.example.logix.ui.viewmodel.LogixViewModel

@Composable
fun LogixApp() {
    // Initialize NavController
    val navController = rememberNavController()

    // Access the LogixViewModel
    val logixViewModel: LogixViewModel = viewModel()

    // Observe the login state
    val isLoggedIn = logixViewModel.userLoggedIn.observeAsState(false)

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            // LoginScreen will be shown if the user is not logged in
            LoginScreen(
                onLoginSuccess = {
                    logixViewModel.loginUser() // Call login function
                    navController.navigate("activity") // Navigate to HomeScreen after login success
                },
                onSignUpClick = {},
                onForgotPasswordClick = {}
            )
        }

        composable("activity") {
            ActivityScreen(
                logixItem = LogixActivityData.ActivityData,
                navController = navController,
                onBackButtonPressed = {
                    navController.navigate("home")}
            )
        }

        composable("home") {
            // HomeScreen will be shown after login success
            HomeScreen(logixViewModel = logixViewModel, navController = navController)
        }
    }
}

@Composable
fun HomeScreen(logixViewModel: LogixViewModel, navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Welcome, ${logixViewModel.email.value ?: "User"}!")

        Button(
            onClick = {
                logixViewModel.logoutUser() // Trigger logout
                navController.navigate("login") // Navigate back to login screen on logout
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LogixApp()
}
