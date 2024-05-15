package com.example.daggermvvm.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggermvvm.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    //fun getMap(): Map<String, ViewModel>

    fun getMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    interface factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}

// Factory for binding context at runtime so dagger can use context anytime

//create a fun to access Map