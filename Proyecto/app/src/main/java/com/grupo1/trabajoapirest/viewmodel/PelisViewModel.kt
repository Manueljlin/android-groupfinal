package com.grupo1.trabajoapirest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grupo1.trabajoapirest.dataclass.Movies.MoviesList
import com.grupo1.trabajoapirest.retrofit.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PelisViewModel: ViewModel() {

    private val repositorio by lazy { Repositorio() }
    private val popularMovies by lazy { MutableLiveData<MoviesList>() }

    fun getPopularMovies(page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPopularMovies(page = page)

            if (response.isSuccessful) {
                val respuesta = response.body()
                respuesta?.let{
                    popularMovies.postValue(it)
                }
            }
        }
    }
}