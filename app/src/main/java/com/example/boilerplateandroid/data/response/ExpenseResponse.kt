package com.example.boilerplateandroid.data.response

import com.google.gson.annotations.SerializedName

data class ExpenseResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("date")
    val date: String
)