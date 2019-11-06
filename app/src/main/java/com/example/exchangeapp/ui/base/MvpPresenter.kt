package com.example.exchangeapp.ui.base

interface MvpPresenter<V : MvpView> {

    fun attach(view: V)

    fun detach()
}