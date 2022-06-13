package com.grupo1.trabajoapirest.retrofit

import com.grupo1.trabajoapirest.API_KEY
import com.grupo1.trabajoapirest.dataclass.Movies.GetMovieImages.MovieImages
import com.grupo1.trabajoapirest.dataclass.Movies.Movie
import com.grupo1.trabajoapirest.dataclass.Movies.MoviesList
import com.grupo1.trabajoapirest.dataclass.People.GetPersonDetails.Person
import com.grupo1.trabajoapirest.dataclass.People.GetPopularPeople.PeopleList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
//
//  MOVIES :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//
    /**
     * Get Movie Details
     * @param movie_id
     * @param api_key?
     * @param language?
     * @return Movie
     *
     * @author Manuel
     * @see <a href="https://developers.themoviedb.org/3/movies/get-movie-details">Reference</a>
     */
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id")  movie_id: Int,
        @Query("api_key")  api_key: String = API_KEY.MovieApiToken,
        @Query("language") language: String = "es-ES"
    ): Response<Movie>


    /**
     * Get Popular Movies
     * -- NOTE: NO OPTIONAL TIME region PARAM INCLUDED
     * @param api_key?
     * @param language?
     * @param page?
     * @return MoviesList
     *
     * @author Manuel
     * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies">Reference</a>
     */
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")  api_key: String = API_KEY.MovieApiToken,
        @Query("language") language: String = "es-ES",
        @Query("page")     page: Int = 0
    ): Response<MoviesList>


    /**
     * Get a Movie's Images
     * -- NOTE: CONCAT WITH BASE URL FROM getApiConfiguration TO COMPLETE THE URL
     * -- NOTE: NO OPTIONAL include_image_language PARAM INCLUDED
     * @param movie_id
     * @param api_key?
     * @param language?
     * @return
     *
     * @author Manuel
     * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies">Reference</a>
     */
    @GET("/movie/{movie_id}/images")
    suspend fun getMovieImages(
        @Path("movie_id")  movie_id: Int,
        @Query("api_key")  api_key: String = API_KEY.MovieApiToken,
        @Query("language") language: String = "es-ES",
    ): Response<MovieImages>


//
//  PEOPLE :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//
    /**
     * Get Person Details
     * @param person_id
     * @param api_key?
     * @param language?
     * @return Person
     *
     * @author Manuel
     * @see <a href="https://developers.themoviedb.org/3/people/get-person-details">Reference</a>
     */
    @GET("person/{person_id}")
    suspend fun getPersonDetails(
        @Path("person_id") person_id: Int,
        @Query("api_key")  api_key: String = API_KEY.MovieApiToken,
        @Query("language") language: String = "es-ES"
    ): Response<Person>


    /**
     * Get Popular People
     * @param api_key?
     * @param language?
     * @param page?
     * @return PopularPeople
     *
     * @author Manuel
     * @see <a href="https://developers.themoviedb.org/3/movies/get-popular-movies">Reference</a>
     */
    @GET("movie/popular")
    suspend fun getPopularPeople(
        @Query("api_key")  api_key: String = API_KEY.MovieApiToken,
        @Query("language") language: String = "es-ES",
        @Query("page")     page: Int = 0
    ): Response<PeopleList>
}