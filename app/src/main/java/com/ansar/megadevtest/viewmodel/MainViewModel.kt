package com.ansar.megadevtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ansar.megadevtest.api.FixerIOService
import com.ansar.megadevtest.api.RatesResponse
import kotlinx.coroutines.launch

class MainViewModel(private val service: FixerIOService) : ViewModel() {

    val ratesResponse : MutableLiveData<RatesResponse> = MutableLiveData()

    fun getRates(accessToken: String) {
        viewModelScope.launch {
            val response = service.getRates(accessToken)
            ratesResponse.postValue(response)
        }
    }
}
