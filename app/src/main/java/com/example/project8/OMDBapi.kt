package com.example.project8


import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "4d23ddf4"

public interface OMDBapi {
    /**
     * Performs a search for movies based on the provided title.
     *
     * @param title The title of the movie to search for.
     * @return A Call object representing the asynchronous request for a list of OMDBMovie objects.
     */
    @GET("?apikey=$API_KEY")
    fun search(@Query("t") title: String): Call<OMDBMovie>
}
