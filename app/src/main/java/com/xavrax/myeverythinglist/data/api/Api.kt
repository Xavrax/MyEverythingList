package com.xavrax.myeverythinglist.data.api

import com.xavrax.myeverythinglist.data.model.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    companion object{
        val API_KEY = "9fc45c50fa65bec2466eeeb6f3370f7a"
    }
    @GET("movie/popular")
    fun getPopularMovies(
        // don't steal, please :)
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("search/movie")
    fun getSearchMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int,
        @Query("query") query: String
    ): Call<GetMoviesResponse>
}