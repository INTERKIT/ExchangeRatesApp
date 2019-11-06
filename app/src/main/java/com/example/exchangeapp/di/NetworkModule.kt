package com.example.exchangeapp.di

import com.example.exchangeapp.data.network.HttpClientBuilder
import com.example.exchangeapp.data.network.RetrofitBuilder
import org.koin.dsl.module

object NetworkModule : InjectionModule {

    override fun create() = module {
        single { HttpClientBuilder.create() }

        single { RetrofitBuilder.create(get()) }
    }
}