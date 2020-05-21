package com.xavrax.myeverythinglist.data.api

import com.xavrax.myeverythinglist.data.model.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getPopularMovies(
        // don't steal, please :)
        @Query("api_key") apiKey: String = "9fc45c50fa65bec2466eeeb6f3370f7a",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}