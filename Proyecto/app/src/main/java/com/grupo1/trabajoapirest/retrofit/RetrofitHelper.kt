package com.grupo1.trabajoapirest.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper
{
	val BASEURL = "https://api.themoviedb.org/3/"

	var retrofitService: RetrofitService? = null

	fun getRetrofit(): RetrofitService
	{
		if (retrofitService == null) {
			val retrofit = Retrofit.Builder()
				.baseUrl(BASEURL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(OkHttpClient())
				.build()

			retrofitService = retrofit.create(RetrofitService::class.java)
		}

		return retrofitService!!
	}
}