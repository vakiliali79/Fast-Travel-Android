package com.alivakili.travel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.travel.R
import com.alivakili.travel.databinding.ToursItemListBinding
import com.alivakili.travel.models.TourModel
import com.squareup.picasso.Picasso


class ToursRecyclerViewAdapter(
    private val items: TourModel,
    private val onClicked:(TourModel.Tour)-> Unit,
    private val context: Context,
) : RecyclerView.Adapter<ToursRecyclerViewAdapter.TourViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TourViewHolder {
        return TourViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val tour = items.tours?.get(position)
        if (tour != null) {
            holder.bind(tour)
        }
    }

    override fun getItemCount(): Int {
        return items.tours?.size ?: 0
    }

    class TourViewHolder(
        private val binding: ToursItemListBinding,
        private val onClicked: (TourModel.Tour)->Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tour: TourModel.Tour) {

            binding.tourNameTV.text=tour.title
            loadImage(context = context, url = tour.image)
            binding.durationTV.text=tour.days.toString()
            binding.cityNameTV.text=tour.location
            val price=tour.price.toString()+" SEK"
            binding.priceTV.text=price
            binding.root.setOnClickListener(View.OnClickListener {
                onClicked(tour)
            })
            binding.reserveTourCV.setOnClickListener(View.OnClickListener {
                onClicked(tour)
            })

        }

        private fun loadImage(url:String?,context: Context) {
            Picasso.with(context).load(url).fit().centerCrop()
                .placeholder(R.drawable.tour_error)
                .error(R.drawable.tour_error)
                .into(binding.imageIV);

        }

        companion object {
            fun create(parent: ViewGroup, onClicked:(TourModel.Tour)->Unit, context: Context): TourViewHolder {
                val binding = ToursItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return TourViewHolder(binding = binding, onClicked = onClicked, context = context)
            }
        }
    }


}