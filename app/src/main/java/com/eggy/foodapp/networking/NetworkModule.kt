package com.eggy.foodapp.networking

import com.eggy.foodapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun getRetrofit():ApiServices{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}