package com.alivakili.travel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.models.FlightsModel
import com.alivakili.travel.adapters.FlightsRecyclerViewAdapter
import com.alivakili.travel.R
import com.alivakili.travel.ReadJSONFromAssets
import com.google.gson.Gson

class FlightsFragment: Fragment() {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.flights_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        properRecyclerView()
    }

    private fun properRecyclerView() {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/flights.json"), FlightsModel::class.java)
        val itemAdapter= FlightsRecyclerViewAdapter(data, onClicked =::flightDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }

    private fun flightDetails(flight: FlightsModel.Flight){
    }

}