package com.example.daggermvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    //private val repository: ProductRepository,
    //private val randomize: Randomize
    //private val mainViewModel: MainViewModel
    private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return MainViewModel(repository, randomize) as T

        //return mainViewModel as T

        return map[modelClass] as T
    }
}

//@JvmSuppressWildcards used for Kotlin