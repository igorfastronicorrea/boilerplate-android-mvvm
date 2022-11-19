package com.example.boilerplateandroid.data.response

import com.google.gson.annotations.SerializedName

data class SportsmanResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("sports")
    val sports: List<String>
)