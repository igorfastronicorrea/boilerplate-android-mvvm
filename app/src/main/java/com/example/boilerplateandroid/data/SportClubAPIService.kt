package com.example.boilerplateandroid.data

import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman
import retrofit2.http.GET

interface SportClubAPIService {
    @GET("sportsmannearby")
    suspend fun fetchSportsmanNearby() : SportsmanNearbyResponse

    @GET("sportsman")
    suspend fun fetchSportsmanById() : SportsmanResponse
}