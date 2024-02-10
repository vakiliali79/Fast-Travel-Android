package com.alivakili.travel.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.models.CarsModel
import com.alivakili.travel.adapters.CarsRecyclerViewAdapter
import com.alivakili.travel.R
import com.alivakili.travel.ReadJSONFromAssets
import com.alivakili.travel.activities.CarDetailsActivity
import com.google.gson.Gson

class CarsFragment: Fragment()  {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.cars_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        properRecyclerView()
    }

    private fun properRecyclerView() {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/cars.json"), CarsModel::class.java)
        val itemAdapter= CarsRecyclerViewAdapter(data, onClicked =::carDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }

    private fun carDetails(car: CarsModel.Car){
        var intent= Intent(requireContext(), CarDetailsActivity::class.java)
        intent.putExtra("KEY_CAR",car)
        startActivity(intent)
    }
}