package com.example.boilerplateandroid.repository.sportman_detail

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman

interface SportsmanResponseToModelMapper{
    fun transformToMapper(sportsmanResponse: SportsmanResponse) : Sportsman
}

class SportsmanResponseToModelMapperImpl : SportsmanResponseToModelMapper {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun transformToMapper(sportsmanResponse: SportsmanResponse): Sportsman {

        return Sportsman(
            id = sportsmanResponse.id,
            name = sportsmanResponse.name,
            age = sportsmanResponse.age,
            distance = sportsmanResponse.distance,
            sports = sportsmanResponse.sports
        )
    }
}