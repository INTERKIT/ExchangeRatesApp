package com.example.exchangeapp.di

import com.example.exchangeapp.data.network.ApiConfig
import com.example.exchangeapp.data.network.HttpClientBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule : InjectionModule {

    override fun create() = module {
        single { HttpClientBuilder.create() }
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(get())
                .build()
        }
    }
}