package com.eggy.foodapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eggy.foodapp.model.FoodResponse
import com.eggy.foodapp.networking.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var data = MutableLiveData<FoodResponse>()


    init {
        getData()
    }

    fun getData() {
        NetworkModule.getRetrofit().getFoodData().enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                data.value = null
                Log.e("errrVM", t.message.toString())
            }
        })
    }

    fun setData(): LiveData<FoodResponse> {
        return data
    }

}