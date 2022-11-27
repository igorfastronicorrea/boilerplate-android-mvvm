package com.example.boilerplateandroid.repository.sportman_detail

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.boilerplateandroid.data.SportClubAPIService
import com.example.boilerplateandroid.model.Sportsman
import com.example.boilerplateandroid.utils.NetworkResult

class SportsmanDetailsRepositoryImpl(
    private val api : SportClubAPIService,
    private val mapper: SportsmanResponseToModelMapper
) : SportsmanDetailsRepository{

    override suspend fun fetchSportsmanDetails(): NetworkResult<Sportsman> {
        val response = api.fetchSportsmanById()
        val sportsman = mapper.transformToMapper(response)

        return NetworkResult.Success(sportsman)
    }


}