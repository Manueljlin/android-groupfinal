package com.grupo1.trabajoapirest.retrofit

import com.grupo1.trabajoapirest.API_KEY
import retrofit2.http.Headers

interface RetrofitService {
    @Headers("api_key:${API_KEY.MovieApiToken}")
}