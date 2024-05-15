package com.example.daggermvvm

import android.app.Application
import com.example.daggermvvm.di.ApplicationComponent
import com.example.daggermvvm.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        // For builder
        //applicationComponent = DaggerApplicationComponent.builder().build()

        //For Factory(runtime)
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}
//Initialise the Component
//mention the class in manifest file