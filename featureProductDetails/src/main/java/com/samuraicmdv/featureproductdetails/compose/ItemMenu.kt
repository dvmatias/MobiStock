package com.samuraicmdv.featureproductdetails.compose

data class ItemMenu<T>(
    val title: String,
    val item: T? = null,
)