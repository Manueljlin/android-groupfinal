package com.grupo1.trabajoapirest.retrofit

import com.grupo1.trabajoapirest.API_KEY
import com.grupo1.trabajoapirest.dataclass2.ListaPelis2
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.ArrayList

interface RetrofitService {

    @Headers("api_key:${API_KEY.MovieApiToken}")
    @GET("movie/popular")
    suspend fun getPelisPopulares(): Response<ArrayList<ListaPelis2>>

}