package com.example.logix.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LogixViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData to hold email and password
    val email = MutableLiveData<String>()
    private val password = MutableLiveData<String>()

    // LiveData to hold login state
    val userLoggedIn = MutableLiveData<Boolean>(false)

    // Function to handle login (simplified)
    fun loginUser() {
        if (!email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()) {
            userLoggedIn.value = true
        }
    }

    fun logoutUser() {
        email.value = ""
        password.value = ""
        userLoggedIn.value = false
    }
}
