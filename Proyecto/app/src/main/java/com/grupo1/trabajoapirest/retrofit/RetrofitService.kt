package com.grupo1.trabajoapirest.retrofit

import com.grupo1.trabajoapirest.API_KEY
import com.grupo1.trabajoapirest.dataclass.Movies.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.ArrayList

interface RetrofitService {

    // movie
        // get details
        // https://developers.themoviedb.org/3/movies/get-movie-details
    @Headers("api_key:${API_KEY.MovieApiToken}")
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int
    ): Response<MovieDetails>

        //
}