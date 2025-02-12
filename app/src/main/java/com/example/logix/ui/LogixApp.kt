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

@Composable
fun LogixApp() {

    val navController = rememberNavController()

    val logixViewModel: LogixViewModel = viewModel()

    val isLoggedIn = logixViewModel.userLoggedIn.observeAsState(false)

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    logixViewModel.loginUser()
                    navController.navigate("activity")
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
                    navController.navigate("home")
                }
            )
        }

        composable("home") {
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
                logixViewModel.logoutUser()
                navController.navigate("login")
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
