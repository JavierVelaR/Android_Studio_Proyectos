package com.example.parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Inflar el diseño XML de la segunda actividad
        val rootView: View = LayoutInflater.from(this).inflate(R.layout.activity_result, null)
        setContentView(rootView)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val fecha = intent.getStringExtra("fecha")
        val urgencia = intent.getBooleanExtra("urgente", false)

        val tvNombre = findViewById<TextView>(R.id.nombre)
        tvNombre.text = nombre

        val tvApellido = findViewById<TextView>(R.id.apellido)
        tvApellido.text = apellido

        val tvFecha = findViewById<TextView>(R.id.fecha)
        tvFecha.text = fecha

        val tvUrgencia = findViewById<TextView>(R.id.urgencia)
        if(urgencia){
            tvUrgencia.text = "Cita urgente"
        }else{
            tvUrgencia.text = ""
        }
    }
}