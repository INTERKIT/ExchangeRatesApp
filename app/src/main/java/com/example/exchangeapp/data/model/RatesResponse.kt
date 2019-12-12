package com.example.exchangeapp.data.model

import com.google.gson.annotations.SerializedName

data class RatesResponse(

    @SerializedName("rates")
    val rates: HashMap<String, Double>
)