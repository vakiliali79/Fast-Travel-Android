package com.alivakili.travel.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.R
import com.alivakili.travel.ReadJSONFromAssets
import com.alivakili.travel.models.TourModel
import com.alivakili.travel.adapters.ToursRecyclerViewAdapter
import com.alivakili.travel.activities.TourDetailsActivity
import com.google.gson.Gson

class ToursFragment: Fragment()  {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.tours_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        properRecyclerView()

    }

    private fun properRecyclerView() {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/tours.json"), TourModel::class.java)
        val itemAdapter= ToursRecyclerViewAdapter(data, onClicked =::tourDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }

    private fun tourDetails(tour: TourModel.Tour){
        var intent= Intent(requireContext(), TourDetailsActivity::class.java)
        intent.putExtra("KEY_TOUR",tour)
        startActivity(intent)
    }

}