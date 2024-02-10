package com.alivakili.travel.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class TourModel(
    @SerializedName("tours")
    val tours: List<Tour?>? = listOf()
) {
    @Parcelize
    data class Tour(
        @SerializedName("days")
        val days: Int? = 0,
        @SerializedName("details")
        val details: String? = "",
        @SerializedName("image")
        val image: String? = "",
        @SerializedName("location")
        val location: String? = "",
        @SerializedName("price")
        val price: Int? = 0,
        @SerializedName("title")
        val title: String? = ""
    ): Parcelable {
        constructor(dto: Tour):this(
            days=dto.days,
            details=dto.details,
            image=dto.image,
            location=dto.location,
            price=dto.price,
            title=dto.title,
        )
    }
}