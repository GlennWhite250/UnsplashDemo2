package com.example.unsplashdemo2.data.remote

import com.example.unsplashdemo2.BuildConfig
import com.example.unsplashdemo2.model.SearchResult
import com.example.unsplashdemo2.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    //@Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("order_by")
        order_by: String,
        @Query("client_id")
        client_id: String,
        @Query("page")
        page:Int,
        @Query("per_page")
        per_page: Int
    ):List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query")
        query:String,
        @Query("per_page")
        per_page: Int
    ): SearchResult

}