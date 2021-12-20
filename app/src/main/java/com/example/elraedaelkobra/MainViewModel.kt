package com.example.elraedaelkobra

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elraedaelkobra.model.AudioFiles
import com.example.elraedaelkobra.model.Post
import com.example.elraedaelkobra.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<AudioFiles>> = MutableLiveData()


    fun getPost() {

        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(suraNumber: Int, ayahNumber: Int) {

        viewModelScope.launch {
            val response: Response<Post> = repository.getPost2(suraNumber, ayahNumber)
            myResponse2.value = response

        }
    }

    fun getRecitation(ayah_key: String) {

        viewModelScope.launch {
            val response: Response<AudioFiles> = repository.getRecitation(ayah_key)
            myResponse3.value = response

        }

    }
}