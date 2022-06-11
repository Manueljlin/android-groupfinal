package com.grupo1.trabajoapirest.retrofit

import com.grupo1.trabajoapirest.API_KEY
import com.grupo1.trabajoapirest.dataclass.popularmovies.popularMovies
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    @Headers("api_key:${API_KEY.MovieApiToken}")
    @GET("movie/popular")
    suspend fun getPeliculas(): Response<ArrayList<>>
}