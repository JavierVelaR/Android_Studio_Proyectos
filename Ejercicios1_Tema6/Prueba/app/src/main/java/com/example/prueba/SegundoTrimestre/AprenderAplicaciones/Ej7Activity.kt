package com.example.prueba.SegundoTrimestre.AprenderAplicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.prueba.R

class Ej7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej7)
        val btnStart = findViewById<AppCompatButton>(R.id.botonStart)
        val etName = findViewById<AppCompatEditText>(R.id.campoNombre)

        btnStart.setOnClickListener{
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                val intent = Intent(this, Result::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)            }
        }
    }
}