package com.example.cardViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val ingresos = intent.getIntExtra("ingresos",0)
        val edad = intent.getIntExtra("edad",0)
        val opcionSeleccionada = intent.getStringExtra("opcion")?:toString()

        val tvResultado = findViewById<TextView>(R.id.resultado)
        tvResultado.text = "Ingresos:\n$ingresos € al mes\nEdad: $edad\nOpción elegida: $opcionSeleccionada"
    }
}