package com.jeyhamilton.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.jeyhamilton.myapplication.common.Constantes

class ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val btCiudad = findViewById<Button>(R.id.btCiudad)
        val btCiudades = findViewById<Button>(R.id.btCiudades)

        btCiudad.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constantes.CIUDAD, "ciudad-maracay")
            startActivity(intent)
        })
        btCiudades.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constantes.CIUDAD, "ciudad-beijing")
            startActivity(intent)
        })
    }
}
