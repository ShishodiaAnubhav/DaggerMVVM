package com.example.daggermvvm.di

import androidx.lifecycle.ViewModel
import com.example.daggermvvm.viewmodels.MainViewModel
import com.example.daggermvvm.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
    //@StringKey("mainViewModel")
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    //@StringKey("mainViewModel2")
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel
}

//@StringKey is used to define a key in String
//@IntoMap is used add info in map
//to differentiate b/w the fun with same return type
//create an entry in Component

//@ClassKey is used hold the Class