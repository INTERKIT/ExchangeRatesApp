package com.example.exchangeapp.utils

import java.math.BigDecimal
import java.math.RoundingMode

object NumberUtils {

    fun round(value: Double, places: Int): Double {
        if (places < 0) return value

        val bigDecimal = BigDecimal.valueOf(value)
        return bigDecimal.setScale(places, RoundingMode.HALF_UP).toDouble()
    }
}