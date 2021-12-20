package com.example.elraedaelkobra.api

import com.example.elraedaelkobra.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("tafseer/1/1/1")
    suspend fun getPost(): Response<Post>

    @GET("tafseer/1/{sura_number}/{ayah_number}")
    suspend fun getPost2(
        @Path("sura_number")
        sura_number: Int,
        @Path("ayah_number")
        ayah_number: Int
    ): Response<Post>

}