package com.alivakili.travel.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alivakili.travel.fragments.CarsFragment
import com.alivakili.travel.fragments.FlightsFragment
import com.alivakili.travel.R
import com.alivakili.travel.fragments.ToursFragment
import com.alivakili.travel.databinding.ActivityMain2Binding
import com.alivakili.travel.fragments.HotelFragment

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var preFragment: Fragment= ToursFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        setCurrFragment(ToursFragment())
        configureToolbar("Tours")
        binding.hotelIconIV.setOnClickListener(View.OnClickListener {
            openHotelFragment()
        })
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tours -> {
                    setCurrFragment(ToursFragment())
                    configureToolbar("Tours")
                    true
                }
                R.id.flights -> {
                    setCurrFragment(FlightsFragment())
                    configureToolbar("Flights")
                    true
                }
                R.id.cars -> {
                    setCurrFragment(CarsFragment())
                    configureToolbar("Cars")
                    true
                }

                else -> {
                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                    false
                }
            }
        }
    }

    private fun openHotelFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HotelFragment())
            .commit()
    }

    private fun configureToolbar(title:String){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title=title

        }
    }

    private fun setCurrFragment(fragment : Fragment){

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }

    }
}