package com.alivakili.travel.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alivakili.travel.models.CarsModel
import com.alivakili.travel.R
import com.alivakili.travel.databinding.ActivityCarDetailsBinding
import com.squareup.picasso.Picasso

class CarDetailsActivity : AppCompatActivity() {
    private  var car: CarsModel.Car?=null
    private lateinit var binding:ActivityCarDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        car=properData()
        properLayout()
        configureToolbar("Car Details")
    }

    private fun properLayout() {
        binding.apply {
            carPriceTV.text=car?.pricePerDay.toString()+" SEK / day"
            carDetailsTV.text=car?.details
            car?.image?.let { Log.e("TAG", it, ) }
            carSeatsTV.text=car?.seat.toString()
            carNameTV.text=car?.name
            carTrasmitionTV.text=car?.transmission
        }
        loadImage(car?.image,this)
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
    private fun properData(): CarsModel.Car? {
        return intent.extras!!.getParcelable("KEY_CAR")
    }
    private fun loadImage(url:String?,context: Context) {
        if (url != null) {
            Log.e("TAG", url )
        }
        Picasso.with(context).load(url).fit().centerCrop()
            .placeholder(R.drawable.car_error)
            .error(R.drawable.car_error)
            .into(binding.carImageIV);

    }
}