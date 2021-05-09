package com.ansar.megadevtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ansar.megadevtest.databinding.ItemListCurrencyBinding
import com.ansar.megadevtest.model.Rates

class CurrencyAdapter: RecyclerView.Adapter<CurrencyHolder>() {

    private val list: MutableList<Rates> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        return CurrencyHolder(ItemListCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        holder.bindViews(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addAll(list: MutableList<Rates>) {
        for (rate in list) {
            this.list.add(rate)
        }
        notifyDataSetChanged()
    }
}