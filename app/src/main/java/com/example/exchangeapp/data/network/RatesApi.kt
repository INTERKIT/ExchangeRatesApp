package com.example.exchangeapp.data.network

import com.example.exchangeapp.data.model.RatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesApi {

    @GET("latest")
    suspend fun fetchRates(@Query("base") base: String): RatesResponse
}