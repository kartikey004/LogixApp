package com.example.logix.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavController


data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val loginError: Boolean = false,
)

class LogixUiState {
    var loginUiState by mutableStateOf(LoginUiState())

    // Function to validate credentials
    fun validateCredentials(email: String, password: String): Boolean {
        // Add logic for actual validation
        return email.isNotEmpty() && password.isNotEmpty()
    }

    fun onLoginSuccess(navController: NavController) {
        navController.navigate("activity_screen")
    }

    fun updateLoginState(email: String, password: String) {
        loginUiState = loginUiState.copy(email = email, password = password)
    }

    fun resetLoginError() {
        loginUiState = loginUiState.copy(loginError = false)
    }

    fun showLoginError() {
        loginUiState = loginUiState.copy(loginError = true)
    }
}
