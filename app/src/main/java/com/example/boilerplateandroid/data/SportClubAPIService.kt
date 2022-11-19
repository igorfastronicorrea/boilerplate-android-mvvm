package com.example.boilerplateandroid.data

import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import retrofit2.http.GET

interface SportClubAPIService {
    @GET("sportsmannearby")
    suspend fun fetchSportsmanNearby() : SportsmanNearbyResponse
}