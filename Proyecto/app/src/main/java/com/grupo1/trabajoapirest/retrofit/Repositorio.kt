package com.grupo1.trabajoapirest.retrofit

class Repositorio {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMovieDetails(movie_id: Int)   = retrofit.getMovieDetails(movie_id = movie_id)
    suspend fun getPopularMovies(page: Int)      = retrofit.getPopularMovies(page = page)
    suspend fun getMovieImgs(movie_id: Int)      = retrofit.getMovieImages(movie_id = movie_id)
    suspend fun getMovieGenres()                 = retrofit.getMovieGenres()

    suspend fun getPersonDetails(person_id: Int) = retrofit.getPersonDetails(person_id = person_id)
    suspend fun getPopularPeople(page: Int)      = retrofit.getPopularPeople(page = page)

    suspend fun getApiConfiguration()            = retrofit.getApiConfiguration()
}