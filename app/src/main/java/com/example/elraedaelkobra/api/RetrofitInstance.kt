package com.example.elraedaelkobra.api

import com.example.elraedaelkobra.util.Constants.Companion.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: API by lazy {

        retrofit.create(API::class.java)
    }
}