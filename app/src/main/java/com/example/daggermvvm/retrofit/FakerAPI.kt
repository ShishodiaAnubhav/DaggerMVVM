package com.example.daggermvvm.retrofit

import com.example.daggermvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}

//create a fun for endpoints using @GET return type will be Response

