package com.alivakili.travel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.databinding.FlightsItemListBinding
import com.alivakili.travel.models.FlightsModel

class FlightsRecyclerViewAdapter (
    private val items: FlightsModel,
    private val onClicked:(FlightsModel.Flight)-> Unit,
    private val context: Context,
) : RecyclerView.Adapter<FlightsRecyclerViewAdapter.FlightViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            FlightViewModel {
        return FlightViewModel.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: FlightViewModel, position: Int) {
        val flight = items.flights?.get(position)
        if (flight != null) {
            holder.bind(flight)
        }
    }

    override fun getItemCount(): Int {
        return items.flights?.size ?: 0
    }

    class FlightViewModel(
        private val binding: FlightsItemListBinding,
        private val onClicked: (FlightsModel.Flight)->Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(flight: FlightsModel.Flight) {

            binding.apply {
                desTimeTV.text=flight.arrival
                destinationTV.text=flight.to
                sourceTV.text=flight.from
                priceTV.text=flight.price
                srcTimeTV.text=flight.departure
                timeHourTV.text=flight.durationInHours.toString()
                if(flight.stops!! >0)
                    stopCondotionTV.text=flight.stops.toString()+" stop"
            }
            binding.flightDetailsLL.setOnClickListener(View.OnClickListener {
                onClicked(flight)
            })
            binding.root.setOnClickListener(View.OnClickListener {
                onClicked(flight)
            })
        }



        companion object {
            fun create(parent: ViewGroup, onClicked:(FlightsModel.Flight)->Unit, context: Context): FlightViewModel {
                val binding = FlightsItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FlightViewModel(binding = binding, onClicked = onClicked, context = context)
            }
        }
    }


}