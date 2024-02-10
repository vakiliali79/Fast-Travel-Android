package com.alivakili.travel.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class FlightsModel(
    @SerializedName("flights")
    val flights: List<Flight?>? = listOf()
) {
    @Parcelize
    data class Flight(
        @SerializedName("arrival")
        val arrival: String? = "",
        @SerializedName("departure")
        val departure: String? = "",
        @SerializedName("duration_in_hours")
        val durationInHours: Int? = 0,
        @SerializedName("from")
        val from: String? = "",
        @SerializedName("price")
        val price: String? = "",
        @SerializedName("stops")
        val stops: Int? = 0,
        @SerializedName("to")
        val to: String? = ""
    ): Parcelable {
        constructor(dto: Flight):this(
            arrival=dto.arrival,
            price=dto.price,
            departure = dto.departure,
            durationInHours = dto.durationInHours,
            from =dto.from ,
            to =dto.to ,
            stops = dto.stops,

        )
    }
}