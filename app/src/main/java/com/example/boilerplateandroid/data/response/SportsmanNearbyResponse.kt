package com.example.boilerplateandroid.data.response

import com.google.gson.annotations.SerializedName

data class SportsmanNearbyResponse(
    @SerializedName("sportsman")
    val sportsman : List<SportsmanResponse>
)