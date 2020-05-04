package com.iti.mobile.covid19tracker.features.all_countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.iti.mobile.covid19tracker.R
import com.iti.mobile.covid19tracker.databinding.DetailsCountryCardLayoutBinding
import com.iti.mobile.covid19tracker.model.entities.Country
import com.iti.mobile.covid19tracker.utils.SUBSCRIBED
import com.iti.mobile.covid19tracker.utils.UN_SUBSCRIBED


class CountriesAdapter(countries: List<Country>) :
    RecyclerView.Adapter<CountriesAdapter.CountriesHolder>() {

    var countries: MutableList<Country> = countries.toMutableList()

    inner class CountriesHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
         val country: TextView = itemView.findViewById(R.id.country_textview)
        val confirmed: TextView = itemView.findViewById(R.id.confirmed_cases)
        val recovered: TextView = itemView.findViewById(R.id.recovered_cases)
        val deaths: TextView = itemView.findViewById(R.id.deaths_cases)
        val subscribe: AppCompatImageButton = itemView.findViewById(R.id.subscribe_button)
        private val showDetailsButton: AppCompatImageButton
        private val hideDetails: AppCompatImageButton
        private val showingDetails : LinearLayout

        val detailsCountryCardLayoutBinding : DetailsCountryCardLayoutBinding
        val imageView: ImageView
        init {
            imageView = itemView.findViewById(R.id.flag_imageview)
            hideDetails = itemView.findViewById(R.id.hide_details_button)
            showingDetails = itemView.findViewById(R.id.details_layout)
            showDetailsButton = itemView.findViewById(R.id.info_button)
            detailsCountryCardLayoutBinding = DetailsCountryCardLayoutBinding.inflate(LayoutInflater.from(itemView.context),itemView.findViewById(R.id.details_layout))
            hideDetails.setOnClickListener {
               itemView.performClick()
            }
            showDetailsButton.setOnClickListener {
                itemView.performClick()
            }
            itemView.setOnClickListener {
              if(showingDetails.isVisible) {
                  showDetailsButton.visibility = View.VISIBLE
                  hideDetails.visibility = View.GONE
                  showingDetails.visibility = View.GONE
              }else {
                  showDetailsButton.visibility = View.GONE
                  hideDetails.visibility = View.VISIBLE
                  showingDetails.visibility = View.VISIBLE
              }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CountriesHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.country_card_view,
            parent,
            false
        ) as View
        return CountriesHolder(v)
    }

    override fun onBindViewHolder(holder: CountriesHolder, position: Int) {
        holder.imageView.load(countries[position].countryInfo?.flag)
        holder.country.text = countries[position].country
        holder.confirmed.text = countries[position].active.toString()
        holder.deaths.text = countries[position].deaths.toString()
        holder.recovered.text = countries[position].recovered.toString()
        holder.detailsCountryCardLayoutBinding.criticalCases.text = countries[position].critical.toString()
        holder.detailsCountryCardLayoutBinding.todayCases.text = countries[position].todayCases.toString()
        holder.detailsCountryCardLayoutBinding.todayDeathsCases.text = countries[position].todayDeaths.toString()
        if(countries[position].subscription == SUBSCRIBED){
            holder.subscribe.setImageResource(R.drawable.ic_notifications_black_24dp)
        }else {
            holder.subscribe.setImageResource(R.drawable.ic_miscellaneous)
        }

        holder.subscribe.setOnClickListener{

          if (countries[position].subscription == SUBSCRIBED){
              holder.subscribe.setImageResource(R.drawable.ic_miscellaneous)
              countries[position].subscription = UN_SUBSCRIBED
          }  else {
              holder.subscribe.setImageResource(R.drawable.ic_notifications_black_24dp)
              countries[position].subscription = SUBSCRIBED
          }
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

}