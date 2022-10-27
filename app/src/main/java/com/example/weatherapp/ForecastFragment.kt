package com.example.weatherapp


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.FragmentForcastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import kotlin.system.measureNanoTime

val forecastData = listOf<Forecast>(
    Forecast("72"),
    Forecast("59"),
    Forecast("63"),
    Forecast("71"),
    Forecast("79"),
    Forecast("82"),
    Forecast("67"),
    Forecast("66"),
    Forecast("62"),
    Forecast("80"),
    Forecast("69"),
    Forecast("76"),
    Forecast("77"),
    Forecast("81"),
    Forecast("68"),
    Forecast("70"),
)

class ForecastFragment : Fragment(R.layout.fragment_forcast){

    private lateinit var binding: FragmentForcastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForcastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)

        val dateTimeStamp = 1664553480 // "Sep 30"
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp.toLong(),0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm")
        val formattedTime = timeFormatter.format(dateTime)

        val tempString = resources.getString(R.string.degree_temp, 70)
        Log.d("ForecastFragment", formattedDate)
        Log.d("ForecastFragment", formattedTime)
    }
}