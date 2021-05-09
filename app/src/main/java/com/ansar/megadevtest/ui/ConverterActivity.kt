package com.ansar.megadevtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.ansar.megadevtest.R
import com.ansar.megadevtest.databinding.ActivityConverterBinding
import com.ansar.megadevtest.model.Rates

class ConverterActivity : AppCompatActivity(), TextWatcher {
    private lateinit var binding: ActivityConverterBinding
    private lateinit var rates: Rates

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rates = intent.getSerializableExtra("rates") as Rates
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edtBaseCurrency.requestFocus()
        binding.edtBaseCurrency.addTextChangedListener(this)

        binding.txtCurrencyRate.text = rates.currencyRate.toString()
        binding.txtCurrency.text = rates.currency
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        if (!s.isNullOrEmpty()) {
            val str = s.toString()
            val amount = str.toInt()
            val total = amount * rates.currencyRate

            binding.txtCurrencyRate.text = total.toString()
        }
    }
}