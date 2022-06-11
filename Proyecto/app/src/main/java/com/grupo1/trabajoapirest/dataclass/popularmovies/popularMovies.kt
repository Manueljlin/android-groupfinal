package com.grupo1.trabajoapirest.dataclass.popularmovies

data class popularMovies(
    val page: Int?,
    val results: List<Result?>?,
    val total_pages: Int?,
    val total_results: Int?
)