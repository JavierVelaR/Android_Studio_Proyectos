package com.example.retolayoutinflater

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.marginTop


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar el diseño XML
        val rootView: View = LayoutInflater.from(this).inflate(R.layout.activity_main, null)

        // Obtener referencia al linearLayout (puedes usar el tipo de layout que estés utilizando)
        val linearLayout = rootView.findViewById<LinearLayout>(R.id.linearLayoutContainer)

        // Crear un nuevo TextView dinámicamente
        val nuevoTextView = TextView(this)
        nuevoTextView.text = "Pulsa el botón para continuar"
        nuevoTextView.textSize = 34f
        nuevoTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

        // Agregar el nuevo TextView al contenedor
        linearLayout.addView(nuevoTextView)

        val nuevoButton = AppCompatButton(this)

        nuevoButton.text = "Segunda Actividad"
        nuevoButton.textSize = 24f
        nuevoButton.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        linearLayout.addView(nuevoButton)

        // Establecer la vista inflada en la actividad
        setContentView(rootView)
    }
}

