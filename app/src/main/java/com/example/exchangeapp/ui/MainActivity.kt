package com.example.exchangeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exchangeapp.ui.rates.RatesFragment
import com.example.exchangeapp.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(RatesFragment.create(), addToBackStack = false)
    }
}
