package com.example.boilerplateandroid.repository.nearbyme

import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.utils.NetworkResult

interface FetchNearbyMeRepository {
    suspend fun fetchNearbyMe() : NetworkResult<List<Sportsman>>
}