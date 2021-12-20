package com.example.elraedaelkobra.repository

import com.example.elraedaelkobra.api.RecitationRetrofitInstance
import com.example.elraedaelkobra.api.RetrofitInstance
import com.example.elraedaelkobra.model.AudioFiles
import com.example.elraedaelkobra.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {

        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(suraNumber: Int, ayahNumber: Int): Response<Post> {

        return RetrofitInstance.api.getPost2(suraNumber, ayahNumber)
    }

    suspend fun getRecitation(ayah_key: String): Response<AudioFiles> {

        return RecitationRetrofitInstance.recitationApi.getRecitation(ayah_key)
    }
}