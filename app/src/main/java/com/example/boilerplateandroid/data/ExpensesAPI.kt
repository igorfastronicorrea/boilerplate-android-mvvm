package com.example.boilerplateandroid.data

import retrofit2.http.GET

interface ExpensesAPI {

    @GET("expenses")
    suspend fun fetchNextExpenses() :
}