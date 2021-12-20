package com.example.elraedaelkobra.api

import com.example.elraedaelkobra.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RecitationRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.recitationBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val recitationApi: RecitationAPI by lazy {

        retrofit.create(RecitationAPI::class.java)
    }
}