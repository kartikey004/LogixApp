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

    fun validateCredentials(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

}
