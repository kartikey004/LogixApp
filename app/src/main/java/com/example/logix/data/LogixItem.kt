package com.example.logix.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LogixItem(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
    @StringRes val date: Int
)








