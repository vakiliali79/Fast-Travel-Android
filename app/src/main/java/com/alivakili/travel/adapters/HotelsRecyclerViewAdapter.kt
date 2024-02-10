package com.alivakili.travel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.R
import com.alivakili.travel.databinding.HotelItemListBinding
import com.alivakili.travel.models.HotelModel
import com.squareup.picasso.Picasso

class HotelsRecyclerViewAdapter(
    private val items: HotelModel,
    private val onClicked:(HotelModel.Hotel)-> Unit,
    private val context: Context,
) : RecyclerView.Adapter<HotelsRecyclerViewAdapter.HotelViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HotelViewModel {
        return HotelViewModel.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: HotelViewModel, position: Int) {
        val hotel = items.hotels?.get(position)
        if (hotel != null) {
            holder.bind(hotel)
        }
    }

    override fun getItemCount(): Int {
        return items.hotels?.size ?: 0
    }

    class HotelViewModel(
        private val binding: HotelItemListBinding,
        private val onClicked: (HotelModel.Hotel)->Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hotel: HotelModel.Hotel) {
            binding.apply {
                hotelStarsTV.text=hotel.stars.toString()+" stars"
                price.text=hotel.pricePerNight.toString()
                hotelNameTV.text=hotel.name
            }
            loadImage(hotel.image,context)
            binding.root.setOnClickListener(View.OnClickListener {
                onClicked(hotel)
            })
        }

        private fun loadImage(url:String?,context: Context) {
            Picasso.with(context).load(url).fit().centerCrop()
                .placeholder(R.drawable.tour_error)
                .error(R.drawable.tour_error)
                .into(binding.imageIV);

        }


        companion object {
            fun create(parent: ViewGroup, onClicked:(HotelModel.Hotel)->Unit, context: Context): HotelViewModel {
                val binding = HotelItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HotelViewModel(binding = binding, onClicked = onClicked, context = context)
            }
        }
    }


}