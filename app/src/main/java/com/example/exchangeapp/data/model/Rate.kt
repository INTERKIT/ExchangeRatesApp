package com.example.exchangeapp.data.model

data class Rate(
    val currency: String,
    val value: Double
) {

    fun isZero() = value == 0.0
}