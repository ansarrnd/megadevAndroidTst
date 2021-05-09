package com.ansar.megadevtest.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ansar.megadevtest.Injection
import com.ansar.megadevtest.R
import com.ansar.megadevtest.databinding.ActivityMainBinding
import com.ansar.megadevtest.model.Rates
import com.ansar.megadevtest.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = CurrencyAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.currencyRv.layoutManager = layoutManager
        binding.currencyRv.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(binding.currencyRv.getContext(),
            layoutManager.orientation)
        binding.currencyRv.addItemDecoration(dividerItemDecoration)

        // get the view model
        viewModel = ViewModelProvider(this, Injection.provideViewModelFactory())
            .get(MainViewModel::class.java)

        viewModel.getRates("7c708450718c95c880f9214becff9fd1");

        viewModel.ratesResponse.observe(this, Observer {

            binding.progressBar.visibility = View.GONE

            val list = mutableListOf<Rates>()
            val aed = Rates(R.drawable.ic_united_arab_emirates, "AED", it.rates.get("AED").asDouble)
            val usd = Rates(R.drawable.ic_united_states, "USD", it.rates.get("USD").asDouble)
            val gbp = Rates(R.drawable.ic_united_kingdom, "GBP", it.rates.get("GBP").asDouble)
            val inr = Rates(R.drawable.ic_india, "INR", it.rates.get("INR").asDouble)
            val aud = Rates(R.drawable.ic_australia, "AUD", it.rates.get("AUD").asDouble)
            val cny = Rates(R.drawable.ic_china, "CNY", it.rates.get("CNY").asDouble)
            val sar = Rates(R.drawable.ic_saudi_arabia, "SAR", it.rates.get("SAR").asDouble)
            val kwd = Rates(R.drawable.ic_kuwait, "KWD", it.rates.get("KWD").asDouble)
            val sgd = Rates(R.drawable.ic_singapore, "SGD", it.rates.get("SGD").asDouble)
            list.add(aed)
            list.add(usd)
            list.add(gbp)
            list.add(inr)
            list.add(aud)
            list.add(cny)
            list.add(sar)
            list.add(kwd)
            list.add(sgd)

            Log.d("MainActivity", list.toString())

            adapter.addAll(list)
        })
    }
}