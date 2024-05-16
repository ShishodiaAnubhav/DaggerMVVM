package com.example.daggermvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakerApplication : Application() {


    override fun onCreate() {
        super.onCreate()
    }
}
//Initialise the Component
//mention the class in manifest file