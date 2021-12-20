package com.example.elraedaelkobra.api

import com.example.elraedaelkobra.model.AudioFiles
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecitationAPI {

    @GET("api/v4/recitations/1/by_ayah/{ayah_key}")
    suspend fun getRecitation(

        @Path("ayah_key")
        ayah_key: String
    ): Response<AudioFiles>
}