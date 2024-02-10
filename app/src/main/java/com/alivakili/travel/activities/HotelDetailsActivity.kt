package com.alivakili.travel.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alivakili.travel.R
import com.alivakili.travel.databinding.ActivityHotelDetailsBinding

import com.alivakili.travel.models.HotelModel
import com.squareup.picasso.Picasso

class HotelDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHotelDetailsBinding
    private  var hotel: HotelModel.Hotel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)
        binding= ActivityHotelDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hotel=properData()
        properLayout()
        configureToolbar("hotel Details")
    }

    private fun properLayout() {
        binding.apply {
            price.text=hotel?.pricePerNight.toString()+" SEK / night"
            details.text=hotel?.details
            stars.text=hotel?.stars.toString() + " stars"
            name.text=hotel?.name
            review.text=hotel?.reviews.toString()+" Reviews"
        }
        loadImage(hotel?.image,this)
    }

    private fun configureToolbar(title:String){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title=title
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    private fun properData(): HotelModel.Hotel? {
        return intent.extras!!.getParcelable("KEY_HOTEL")
    }
    private fun loadImage(url:String?,context: Context) {
        if (url != null) {
            Log.e("TAG", url )
        }
        Picasso.with(context).load(url).fit().centerCrop()
            .placeholder(R.drawable.hotels_error)
            .error(R.drawable.hotels_error)
            .into(binding.image);

    }

}