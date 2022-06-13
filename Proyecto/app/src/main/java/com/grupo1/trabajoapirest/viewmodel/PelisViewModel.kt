package com.grupo1.trabajoapirest.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grupo1.trabajoapirest.dataclass.Movies.Movie
import com.grupo1.trabajoapirest.dataclass.Movies.MoviesList
import com.grupo1.trabajoapirest.dataclass.People.GetPersonDetails.Person
import com.grupo1.trabajoapirest.dataclass.People.GetPopularPeople.PeopleList
import com.grupo1.trabajoapirest.retrofit.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PelisViewModel: ViewModel() {

    private val repositorio by lazy { Repositorio() }
    val popularMovies = MutableLiveData<MoviesList>()
    val selectedMovie = MutableLiveData<Movie>()

    val popularPeople by lazy { MutableLiveData<PeopleList>() }
    val selectedPerson = MutableLiveData<Person>()

    fun getPopularMovies(page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPopularMovies(page = page)

            if (response.isSuccessful) {
                val respuesta = response.body()
                respuesta?.let {
                    popularMovies.postValue(it)
                }
            }
        }
    }

    fun getPopularPeople(page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPopularPeople(page = page)

            if (response.isSuccessful) {
                val respuesta = response.body()
                respuesta?.let {
                    popularPeople.postValue(it)
                }
            }
        }
    }


    // esta clase funciona como un constructor del viewmodel
    class MyViewModelFactory(val application: Application): ViewModelProvider.Factory
    {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T
        {
            return modelClass.getConstructor(Application::class.java)
                .newInstance(application)
        }
    }
}