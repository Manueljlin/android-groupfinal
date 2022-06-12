package com.grupo1.trabajoapirest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grupo1.trabajoapirest.dataclass2.ListaPelis2
import com.grupo1.trabajoapirest.retrofit.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PelisViewModel: ViewModel() {

    private val repositorio by lazy { Repositorio() }

    val listaPelisPopulares by lazy { MutableLiveData<ArrayList<ListaPelis2>>() }

    fun getListaPelisPopulares() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPelisPopulares()

            if (response.isSuccessful) {
                val respuesta = response.body()
                respuesta?.let{
                    listaPelisPopulares.postValue(it)
                }
            }
        }
    }
}