package com.example.mb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.repository.ExchangeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {

    private val _listExchanges = MutableLiveData<List<ExchangeDataEntity>>()
    val listExchanges: LiveData<List<ExchangeDataEntity>> = _listExchanges

    fun fetchExchanges() {
        viewModelScope.launch {
            try {
                val response = repository.getBitcoinPrice()
                _listExchanges.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}