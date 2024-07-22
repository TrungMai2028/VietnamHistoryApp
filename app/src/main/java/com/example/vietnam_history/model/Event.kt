package com.example.vietnam_history.model


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Event(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val descriptionResourceId: Int
)
