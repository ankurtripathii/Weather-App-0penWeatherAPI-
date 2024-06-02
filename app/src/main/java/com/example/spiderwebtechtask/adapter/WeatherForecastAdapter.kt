package com.example.spiderwebtechtask.adapter

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.spiderwebtechtask.R
import com.example.spiderwebtechtask.model.forecast.WeatherDataModel
import java.util.*


class WeatherForecastAdapter (private val forecastList: ArrayList<WeatherDataModel>,
    val context: Context) :RecyclerView.Adapter<WeatherForecastAdapter.WeatherForecastHolder>() {

    class WeatherForecastHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var cardView : CardView
        lateinit var forecastTime : TextView
        lateinit var forecastDegree : TextView
        lateinit var forecastImage : ImageView


        fun bind(forecastElement: WeatherDataModel) {

           cardView = itemView.findViewById(R.id.forecastCard)
            forecastTime = itemView.findViewById(R.id.forecastTime)
            forecastDegree = itemView.findViewById(R.id.forecastDegree)
            forecastImage = itemView.findViewById(R.id.forecastImage)

            forecastDegree.text = "${(forecastElement.main.temp - 273.15).toInt()} °C "
            val sdfSource = SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
            val date = sdfSource.parse(forecastElement.dt_txt)
            val sdfDestination = SimpleDateFormat("d MMM hh:mm a")
            forecastTime.text = sdfDestination.format(date)
            forecastTime.text = sdfDestination.format(date)
            updateUI(forecastElement.weather[0].icon)
        }
        private fun updateUI(icon: String) {
            when (icon) {
                "11d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.thunderstorm_bga
                    )
                    forecastImage.setImageResource(R.drawable.thunderstorm)

                }
                "11n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.thunderstorm_bga)
                    forecastImage.setImageResource(R.drawable.thunderstorm)
                }
                "09d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.drizzle_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_rain_night)
                }
                "09n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.drizzle_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_rain_night)

                }
                "10d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.rainy_bga
                    )
                   forecastImage.setImageResource(R.drawable.sun_rain)

                }
                "10n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.rainy_bga_ni8
                    )
                    forecastImage.setImageResource(R.drawable.rainy_night)

                }
                "13d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.rainy_bga
                    )
                    forecastImage.setImageResource(R.drawable.snow_cloud_day)

                }

                "13n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.rainy_bga
                    )
                    forecastImage.setImageResource(R.drawable.snow_cloud_night)

                }
                "50d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.mist_bga
                    )
                    forecastImage.setImageResource(R.drawable.fog_night)

                }
                "50n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.mist_bga
                    )
                    forecastImage.setImageResource(R.drawable.fog_night)
                }
                "01d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.clear_bga
                    )
                    forecastImage.setImageResource(R.drawable.sun_)

                }
                "01n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.clear_bga_night
                    )
                    forecastImage.setImageResource(R.drawable.moon)

                }
                "02d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)

                }
                "02n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga_ni8
                    )
                    forecastImage.setImageResource(R.drawable.cloud_night)

                }
                "03d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)
                }
                "03n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga_ni8
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)
                }
                "04d" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)
                }
                "04n" -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga_ni8
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)
                }
                else -> {
                    cardView.background = ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.cloud_bga
                    )
                    forecastImage.setImageResource(R.drawable.cloud_day)
                }
            }


        }
    }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.weather_forecast_item, parent, false)
            return WeatherForecastHolder(view)


        }

        override fun onBindViewHolder(holder: WeatherForecastHolder, position: Int) {
            forecastList[position].let {
                holder.bind(forecastElement = it)
            }

        }

        override fun getItemCount(): Int = forecastList.size


}
