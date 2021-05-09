package com.ansar.megadevtest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ansar.megadevtest.api.FixerIOService

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val service: FixerIOService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
