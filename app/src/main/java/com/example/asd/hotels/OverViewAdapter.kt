package com.example.asd.hotels

import android.annotation.SuppressLint
import android.util.Log.d
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asd.hotels.dummy.HotelData
import kotlinx.android.synthetic.main.activity_hotel_detail.view.*
import kotlinx.android.synthetic.main.hotel_layout.view.*

class OverViewAdapter(
    private val hotel_details: List<HotelData>,
    private val overviewClicked: () -> Unit
) :
    RecyclerView.Adapter<OverViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            R.layout.hotel_layout,
            parent, false
        )
        return ViewHolder(layoutView)
    }

    // Limits the list of view
    override fun getItemCount() = hotel_details.size

    // For every row different content.
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel_detail = hotel_details[position]
        holder.view.txt_location.text = hotel_detail.location;
        holder.view.txt_price.text = "€ " + hotel_detail.price.toString();
        holder.view.img_hotel.setImageDrawable(
            holder.view.context.getDrawable(hotel_detail.image)
        )
        holder.view.ratingBar.rating = 1;
        holder.view.txt_description.text = hotel_detail.hotel_description;
        holder.view.setOnClickListener {
            d("OverViewAdapter", "clicked!")
            // Callback to the MainActivity
            overviewClicked.invoke()
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}