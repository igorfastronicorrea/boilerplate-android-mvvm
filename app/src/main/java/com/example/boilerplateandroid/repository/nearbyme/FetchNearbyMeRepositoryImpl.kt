package com.example.boilerplateandroid.repository.nearbyme

import com.example.boilerplateandroid.data.SportClubAPIService
import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.utils.NetworkResult

class FetchNearbyMeRepositoryImpl(
    private val api: SportClubAPIService,
    private val mapper: SportsmanModelMapper
): FetchNearbyMeRepository {

    override suspend fun fetchNearbyMe(): NetworkResult<List<Sportsman>> {
        val response = api.fetchSportsmanNearby()
        val sportman: List<Sportsman> = response.sportsman.map {
            mapper.transformToSportsmanModel(it)
        }
        return NetworkResult.Success(sportman)
    }
}