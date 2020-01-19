package com.jeyhamilton.myapplication

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.jeyhamilton.myapplication.common.Ciudad
import com.jeyhamilton.myapplication.common.Constantes
import com.jeyhamilton.myapplication.network.Network.Companion.getNetworkStatus
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var tvCiudad: TextView? = null
    var tvGrados: TextView? = null
    var tvStatus: TextView? = null
    val Constantes = Constantes()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvStatus = findViewById(R.id.tvNublado)
        val ciudad = intent.getStringExtra(Constantes.CIUDAD)
        if (getNetworkStatus(this)) {
            try {
                when (ciudad) {
                    "ciudad-maracay" -> {
                        HTTPSVolley("https://api.openweathermap.org/data/2.5/weather?q=Maracay,VE&appid=9759455f5d2767a40ce63f3b8a35e4fe")
                    }
                    "ciudad-beijing" -> {
                        HTTPSVolley("https://api.openweathermap.org/data/2.5/weather?lat=39.91&lon=116.4&appid=9759455f5d2767a40ce63f3b8a35e4fe")
                    }
                    else -> {
                        Toast.makeText(this, "Ciudad invalida", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "No posee internet", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "No posee internet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun HTTPSVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                try {
                    val gson = Gson()
                    val ciudad = gson.fromJson(response, Ciudad::class.java)
                    tvCiudad?.text = ciudad.name
                    tvGrados?.text = ciudad.main?.temp.toString()
                    tvStatus?.text = ciudad.weather?.get(0)?.description
                } catch (e: Exception) {
                    Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener {
            })
        queue.add(request)
    }
}
