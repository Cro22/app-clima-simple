package com.jeyhamilton.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
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
        val ciudad = intent.getStringExtra(Constantes.CIUDAD)
        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvStatus = findViewById(R.id.tvNublado)

        val ciudadM = Ciudad("Maracay", 15, "Noche")
        val ciudadB = Ciudad("Beijing", 25, "Dia")

        when (ciudad) {
            "ciudad-maracay" -> {
                tvCiudad?.text = ciudadM.nombre
                tvGrados?.text = ciudadM.grados.toString()
                tvStatus?.text = ciudadM.status

            }
            "ciudad-beijing" -> {
                tvCiudad?.text = ciudadB.nombre
                tvGrados?.text = ciudadB.grados.toString()
                tvStatus?.text = ciudadB.status
            }
            else -> {
                Toast.makeText(this, "Ciudad invalida", Toast.LENGTH_SHORT).show()
            }
        }
        if (getNetworkStatus(this)) {
            try {

            } catch (e: Exception) {
                Log.e("se fundio ", "Se fundio")
            }
        }
    }

}
