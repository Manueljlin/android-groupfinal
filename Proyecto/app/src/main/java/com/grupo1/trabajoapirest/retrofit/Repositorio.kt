package com.grupo1.trabajoapirest.retrofit

class Repositorio {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPelisPopulares() = retrofit.getPelisPopulares()
}