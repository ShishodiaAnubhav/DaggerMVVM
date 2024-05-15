package com.example.daggermvvm.di

import com.example.daggermvvm.retrofit.FakerAPI
import com.example.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //define a fun providesRetrofit which will return Retrofit object
    //if we want only one object of retrofit we use @Singleton
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //define another fun providesFakerAPI for the implementation of interface or API
    //we will need retrofit object and it will return FakerAPI
    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit) : FakerAPI {
        return retrofit.create(FakerAPI::class.java)
    }
}



