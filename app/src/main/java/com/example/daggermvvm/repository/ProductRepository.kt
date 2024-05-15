package com.example.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvm.db.FakerDB
import com.example.daggermvvm.models.Product
import com.example.daggermvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI , private val fakerDB: FakerDB) {

    private val _product = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _product

    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _product.postValue(result.body())
        }

    }

}
//repository will need(as a parameter) the object of API which will be provided by Dagger, so will use constructor injection(@Inject)
//expose LiveData from our viewModels which can access data
// a LiveData which is publicly accessible and a getter for MutableLiveData


//add FakerDB in constructor @Inject
//save data in Database