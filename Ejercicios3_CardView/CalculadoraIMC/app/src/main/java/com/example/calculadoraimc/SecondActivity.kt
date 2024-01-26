package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val imc = intent.getDoubleExtra("ResultadoIMC",-1.0)
        val res = intent.getStringExtra("Resultado")
        val txt = intent.getStringExtra("ResultadoTexto")?:toString()

        val tvResultado = findViewById<TextView>(R.id.resultado)
        tvResultado.text = res

        val tvIMC = findViewById<TextView>(R.id.imc)
        tvIMC.text = imc.toString()

        val txtResultado = findViewById<TextView>(R.id.textoResultado)
        txtResultado.text = txt

        val reCalcular = findViewById<AppCompatButton>(R.id.reCalcular)
        reCalcular.setOnClickListener{
            finish()
        }
    }
}