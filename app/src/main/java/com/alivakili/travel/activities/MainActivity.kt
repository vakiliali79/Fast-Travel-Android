package com.alivakili.travel.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.alivakili.travel.databinding.ActivityMainBinding
import com.alivakili.travel.fragments.Fragment1
import com.alivakili.travel.fragments.Fragment2
import com.alivakili.travel.fragments.Fragment3
import com.alivakili.travel.fragments.FragmentAdapter


class MainActivity : AppCompatActivity() {
    lateinit var adapter: FragmentAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        if (sharedPref.getBoolean("isFirstLaunch", true)) {
            // This is the first launch, set the flag to false
            sharedPref.edit().putBoolean("isFirstLaunch", false).apply()
        } else {
            // This is not the first launch, start the second activity and finish the first activity
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
            return
        }
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        // add Fragments in your ViewPagerFragmentAdapter class
        adapter.addFragment(Fragment1())
        adapter.addFragment(Fragment2())
        adapter.addFragment(Fragment3())


        // set Orientation in your ViewPager2

        // set Orientation in your ViewPager2
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager2.adapter = adapter
    }




}