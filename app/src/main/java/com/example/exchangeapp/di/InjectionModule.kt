package com.example.exchangeapp.di

import org.koin.core.module.Module

interface InjectionModule {
    fun create(): Module
}