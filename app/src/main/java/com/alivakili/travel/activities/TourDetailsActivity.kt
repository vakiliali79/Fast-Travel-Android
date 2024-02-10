package com.alivakili.travel.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alivakili.travel.R
import com.alivakili.travel.models.TourModel
import com.alivakili.travel.databinding.ActivityTourDetailsBinding
import com.squareup.picasso.Picasso

class TourDetailsActivity : AppCompatActivity() {
    private var tour: TourModel.Tour? = null
    private lateinit var binding:ActivityTourDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTourDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar("Tour Details")
        tour=properData()
        properLayout()
    }

    private fun properLayout() {
        binding.apply {
            tourDetailsTV.text=tour?.details
            tourLocationTV.text=tour?.location
            tourPriceTV.text=tour?.price.toString()+" SEK"
            tourNameTV.text=tour?.title
            tourDurationTV.text=tour?.days.toString()+" days"
        }
        loadImage(tour?.image,this)
    }


    private fun loadImage(url:String?,context: Context) {
        Picasso.with(context).load(url).fit().centerCrop()
            .placeholder(R.drawable.tour_error)
            .error(R.drawable.tour_error)
            .into(binding.tourImageIV);

    }


    private fun properData(): TourModel.Tour? {
        return intent.extras!!.getParcelable("KEY_TOUR")
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

}