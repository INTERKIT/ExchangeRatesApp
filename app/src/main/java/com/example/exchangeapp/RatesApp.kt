package com.example.exchangeapp

import android.app.Application
import com.example.exchangeapp.di.NetworkModule
import com.example.exchangeapp.di.RatesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class RatesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@RatesApp)
            val modules = listOf(
                NetworkModule.create(),
                RatesModule.create()
            )

            modules(modules)
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}