package com.swvl.movies.data.api

import com.swvl.movies.data.model.FlickrSearchResponse
import com.swvl.movies.utils.Constants
import com.swvl.movies.utils.Constants.BASE_URL_FLICKR
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface FlickrService {


    /**
     * Get photos from flickr.
     */
    @GET("services/rest/")
    suspend fun searchPhotos(
        @Query("text") query: String,
        @Query(value = "method", encoded = true) method: String = "flickr.photos.search",
        @Query(
            value = "api_key",
            encoded = true
        ) api_key: String = Constants.API_KEY_FLICKR,
        @Query(value = "format", encoded = true) format: String = "json",
        @Query(value = "nojsoncallback", encoded = true) nojsoncallback: Int = 1,
        @Query("page") page: Int=1,
        @Query("per_page") itemsPerPage: Int=20
    ): FlickrSearchResponse


    companion object {

        fun create(): FlickrService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL_FLICKR)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FlickrService::class.java)
        }
    }
}