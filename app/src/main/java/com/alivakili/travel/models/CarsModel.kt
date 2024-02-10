package com.alivakili.travel.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CarsModel(
    @SerializedName("cars")
    val cars: List<Car?>? = listOf()
) {
    @Parcelize
    data class Car(
        @SerializedName("details")
        val details: String? = "",
        @SerializedName("image")
        val image: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("price_per_day")
        val pricePerDay: Int? = 0,
        @SerializedName("seat")
        val seat: Int? = 0,
        @SerializedName("transmission")
        val transmission: String? = ""
    ): Parcelable {
        constructor(dto: Car):this(
            name=dto.name,
            details=dto.details,
            image=dto.image,
            pricePerDay = dto.pricePerDay,
            seat=dto.seat,
            transmission = dto.transmission,
        )
    }
}