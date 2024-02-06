package com.example.parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private var urgente by Delegates.notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvUrgente = findViewById<CardView>(R.id.urgente)
        handleCardViewClick(cvUrgente)

        val btnPedirCita = findViewById<AppCompatButton>(R.id.pedirCita)
        btnPedirCita.setOnClickListener {
            val nombre: String = findViewById<AppCompatEditText>(R.id.campoNombre).text.toString()
            val apellido: String = findViewById<AppCompatEditText>(R.id.campoApellido).text.toString()
            val fecha: String = findViewById<AppCompatEditText>(R.id.campoFecha).text.toString()

            //Agregar datos extra al Intent
            intent.putExtra("nombre", nombre)
            intent.putExtra("apellido", apellido)
            intent.putExtra("fecha", fecha)

            if(urgente) {
                println("Se ha notificado una urgencia")
                Log.d("URGENTE", "Se ha notificado una urgencia")
                intent.putExtra("urgente", true)
                Toast.makeText(this, "Cita urgente seleccionada", Toast.LENGTH_LONG).show()

            }

            //ToastMAkeTExt para hacer visible que se ha registrado la cita
            Toast.makeText(this, "Cita pedida con éxito", Toast.LENGTH_LONG).show()

            Log.d("Cita", "Cita pedid con éxito")
            //Crear un Intent para pasar a la segunda actividad
            val intent = Intent(this, ResultActivity::class.java)

            //Iniciar segunda actividad
            startActivity(intent)

        }
    }

    private fun handleCardViewClick(cv: CardView) {
        when (cv.id) {
            R.id.urgente -> {
                //Especificar que la cita es urgente
                urgente = true
            }
        }
    }

}