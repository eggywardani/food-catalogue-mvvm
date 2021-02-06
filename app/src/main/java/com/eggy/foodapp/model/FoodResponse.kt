package com.eggy.foodapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class FoodResponse(

	@field:SerializedName("method")
	val method: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class ResultsItem(

	@field:SerializedName("times")
	val times: String? = null,

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("portion")
	val portion: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("dificulty")
	val dificulty: String? = null
) : Parcelable
