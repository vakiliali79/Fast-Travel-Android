package com.alivakili.travel.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class HotelModel(
    @SerializedName("hotels")
    val hotels: List<Hotel?>? = listOf()
) {
    @Parcelize
    data class Hotel(
        @SerializedName("details")
        val details: String? = "",
        @SerializedName("image")
        val image: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("price_per_night")
        val pricePerNight: Int? = 0,
        @SerializedName("reviews")
        val reviews: Int? = 0,
        @SerializedName("stars")
        val stars: Int? = 0
    ): Parcelable {
        constructor(dto: HotelModel.Hotel):this(
            details=dto.details,
            image=dto.image,
            name=dto.name,
            pricePerNight=dto.pricePerNight,
            reviews=dto.reviews,
            stars=dto.stars,

            )
    }
}