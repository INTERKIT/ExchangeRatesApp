package com.example.exchangeapp.ui.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exchangeapp.R
import com.example.exchangeapp.ui.base.BaseMvpFragment
import org.koin.android.ext.android.inject

class RatesFragment : BaseMvpFragment<RatesContract.View, RatesContract.Presenter>() {

    override val presenter: RatesContract.Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_rates, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun create(): RatesFragment = RatesFragment()
    }
}