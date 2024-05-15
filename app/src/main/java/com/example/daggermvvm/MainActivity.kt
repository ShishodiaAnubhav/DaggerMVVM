package com.example.daggermvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.ui.theme.DaggerMVVMTheme
import com.example.daggermvvm.viewmodels.MainViewModel
import com.example.daggermvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    (application as FakerApplication).applicationComponent.inject(this)

                    //for testing at runtime
                    //val map = (application as FakerApplication).applicationComponent.getMap()

                    mainViewModel =
                        ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

                    ProductView(mainViewModel = mainViewModel)
                }
            }
        }
    }
}

@Composable
fun ProductView(mainViewModel: MainViewModel) {
    val products by mainViewModel.productLiveData.observeAsState()
    Column {
        products?.forEach { product ->
            Text(text = "${product.title}\n\n")
        }
    }
}

/* For Retrofit

//First Covert Api to json using Plugin in module package

//create a utils package --> create a object class for CONSTANTS like BASE_URL etc.

//create an interface FakerAPI for new package Retrofit

//we want that the retrofit object will be provided by retrofit
//so create a module di and create a module for provides methods

//new we will create an interface ApplicationComponent at application level
//so we will an application level Scope

//now Create a repository

//now create a viewModel and viewModelFactory
*/


/* For Room

// define the model as @Entity and set Primary key

// create a new package for database
// create DAO

// create an abstract class for room database i.e. FakerDB

//we get the instance of room database through builder pattern
//so we create a module i.e. Database module

//change from factory to builder in Application

// add DatabaseModule in Component

// now define a property of FakerDB in repository and save the data on database

*/


/* For Multibinding

//change of parameter in ViewModel

//create new  class Randomize in MainViewModel and set it in parameter
//we can also pass it in the factory
//by there is a maintenance problem as change in viewModel leads to change in factory

//to solve this we will use to create a object of MainViewModel, which will pass in the factory



//Binding Multiple ViewModel to single Factory

//create another viewModel

// create an Module class for multiBinding of viewModels

//now access the map in factory


 */




