package com.eggy.foodapp.networking

import com.eggy.foodapp.model.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {



    @GET("api/recipes")
    fun getFoodData(): Call<FoodResponse>
}