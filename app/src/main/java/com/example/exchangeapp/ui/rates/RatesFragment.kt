package com.example.exchangeapp.ui.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangeapp.R
import com.example.exchangeapp.data.model.CurrencyFactory
import com.example.exchangeapp.data.model.Rate
import com.example.exchangeapp.ui.base.BaseMvpFragment
import com.example.exchangeapp.ui.rates.adapter.RatesAdapter
import kotlinx.android.synthetic.main.fragment_rates.*
import org.koin.android.ext.android.inject

class RatesFragment :
    BaseMvpFragment<RatesContract.View, RatesContract.Presenter>(),
    RatesContract.View {

    override val presenter: RatesContract.Presenter by inject()

    private lateinit var ratesAdapter: RatesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_rates, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = CurrencyFactory(requireContext())

        ratesAdapter = RatesAdapter(
            factory = factory,
            onItemClickListener = {
                presenter.setCurrency(it.currency)
                presenter.setAmount(it.value.toString())
            },
            onValueChangedListener = { presenter.setAmount(it) }
        )

        with(recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ratesAdapter
        }

        refreshLayout.setOnRefreshListener { presenter.refresh() }

        presenter.start()
    }

    override fun updateRates(rates: List<Rate>) {
        ratesAdapter.setItems(rates)
        recyclerView.scrollToPosition(0)
    }

    override fun insertRates(rates: List<Rate>) {
        ratesAdapter.insertItems(rates)
    }

    override fun setRefreshing(isRefreshing: Boolean) {
        refreshLayout.isRefreshing = isRefreshing
    }

    override fun showError(resourceId: Int) {
        Toast.makeText(requireContext(), resourceId, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun create(): RatesFragment = RatesFragment()
    }
}