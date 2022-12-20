package com.example.boilerplateandroid.repository.nearbyme

import com.example.boilerplateandroid.data.SportClubAPIService
import com.example.boilerplateandroid.data.response.SportsmanNearbyResponse
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.utils.NetworkResult
import java.lang.RuntimeException


class FetchNearbyMeRepositoryImpl(
    private val api: SportClubAPIService,
    private val mapper: SportsmanModelMapper
): FetchNearbyMeRepository {

    override suspend fun fetchNearbyMe(): NetworkResult<List<Sportsman>> {
        try {
            val response = api.fetchSportsmanNearby()
            val sportsman: List<Sportsman> = response.sportsman.map {
                mapper.transformToSportsmanModel(it)
            }
            return NetworkResult.Success(sportsman)
        }catch (e: Exception){
            NetworkResult.Error<Nothing>(e)
            throw RuntimeException(e)
        }

    }
}