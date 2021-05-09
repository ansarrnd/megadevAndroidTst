package com.ansar.megadevtest.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.ansar.megadevtest.databinding.ItemListCurrencyBinding
import com.ansar.megadevtest.model.Rates

class CurrencyHolder:RecyclerView.ViewHolder {
    private val binding: ItemListCurrencyBinding
    constructor(binding: ItemListCurrencyBinding):super(binding.root) {
        this.binding = binding
    }
    fun bindViews(rates: Rates) {
        binding.imageView.setImageResource(rates.imgSrc)
        binding.txtCurrency.text = rates.currency
        binding.txtCurrencyRate.text = rates.currencyRate.toString()
        binding.layout.setOnClickListener({
            val intent = Intent(it.context, ConverterActivity::class.java)
            intent.putExtra("rates", rates)
            it.context.startActivity(intent)
        })
    }

}