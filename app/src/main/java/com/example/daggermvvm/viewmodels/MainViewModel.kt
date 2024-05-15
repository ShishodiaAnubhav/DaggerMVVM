package com.example.daggermvvm.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvm.models.Product
import com.example.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository, private val randomize: Randomize) : ViewModel() {
    val productLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}
//will take object of repository
// if we use a viewmodel with parameter we need to define viewmodelFactory

class Randomize @Inject constructor() {
    fun doAction(){
        Log.d("CHEEZYCODE", "Random Action")
    }
}