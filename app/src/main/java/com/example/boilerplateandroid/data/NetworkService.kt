package com.example.boilerplateandroid.data

import com.example.boilerplateandroid.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkService {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getAPI() = retrofit.create(SportClubAPIService::class.java)
}