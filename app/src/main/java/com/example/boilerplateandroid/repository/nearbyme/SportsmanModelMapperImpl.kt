package com.example.boilerplateandroid.repository.nearbyme

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.boilerplateandroid.data.response.SportsmanResponse
import com.example.boilerplateandroid.model.Sportsman

interface SportsmanModelMapper {
    fun transformToSportsmanModel(sportsmanResponse: SportsmanResponse): Sportsman
}

class SportsmanModelMapperImpl : SportsmanModelMapper{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun transformToSportsmanModel(sportsmanResponse: SportsmanResponse): Sportsman {

        return Sportsman(
            sportsmanResponse.id,
            sportsmanResponse.name,
            sportsmanResponse.distance,
            sportsmanResponse.age,
            sportsmanResponse.sports
        )
    }
}