// LogixViewModel.kt
package com.example.logix.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LogixViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData to hold email and password
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    // LiveData to hold login state
    val userLoggedIn = MutableLiveData<Boolean>(false)

    // Function to handle login (simplified)
    fun loginUser() {
        if (!email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()) {
            // User has entered both email and password, log them in
            userLoggedIn.value = true
        }
    }

    // Function to handle logout
    fun logoutUser() {
        email.value = ""
        password.value = ""
        userLoggedIn.value = false
    }
}
