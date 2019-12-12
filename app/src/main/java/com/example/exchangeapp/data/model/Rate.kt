package com.example.exchangeapp.data.model

data class Rate(
    val base: String,
    val currency: String,
    val value: Double
) {

    fun isZero() = value == 0.0
}