package com.alivakili.travel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.R
import com.alivakili.travel.databinding.CarsItemListBinding
import com.alivakili.travel.models.CarsModel
import com.squareup.picasso.Picasso

class CarsRecyclerViewAdapter (
    private val items: CarsModel,
    private val onClicked:(CarsModel.Car)-> Unit,
    private val context: Context,
) : RecyclerView.Adapter<CarsRecyclerViewAdapter.CarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CarsViewHolder {
        return CarsViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val car = items.cars?.get(position)
        if (car != null) {
            holder.bind(car)
        }
    }

    override fun getItemCount(): Int {
        return items.cars?.size ?: 0
    }

    class CarsViewHolder(
        private val binding: CarsItemListBinding,
        private val onClicked: (CarsModel.Car)->Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: CarsModel.Car) {

            binding.carNameTV.text=car.name
            binding.priceTV.text=car.pricePerDay.toString()
            loadImage(car.image,context)
            binding.seatsTV.text=car.seat.toString()
            binding.root.setOnClickListener(View.OnClickListener {
                onClicked(car)
            })
        }

        private fun loadImage(url:String?,context: Context) {
            Picasso.with(context).load(url).fit().centerCrop()
                .placeholder(R.drawable.car_error)
                .error(R.drawable.car_error)
                .into(binding.carImageIV);

        }

        companion object {
            fun create(parent: ViewGroup, onClicked:(CarsModel.Car)->Unit, context: Context): CarsViewHolder {
                val binding = CarsItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CarsViewHolder(binding = binding, onClicked = onClicked, context = context)
            }
        }
    }


}