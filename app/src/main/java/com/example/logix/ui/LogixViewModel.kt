package com.example.logix.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LogixViewModel(application: Application) : AndroidViewModel(application) {

    val email = MutableLiveData<String>()
    private val password = MutableLiveData<String>()

    val userLoggedIn = MutableLiveData(false)

    fun loginUser() {
        if (!email.value.isNullOrEmpty() && !password.value.isNullOrEmpty() && isValidEmail(email.value)) {
            userLoggedIn.value = true
        }
        else userLoggedIn.value = false
    }

    fun logoutUser() {
        email.value = ""
        password.value = ""
        userLoggedIn.value = false
    }

    private fun isValidEmail(email: String?): Boolean {
        return email?.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) == true
    }

}
