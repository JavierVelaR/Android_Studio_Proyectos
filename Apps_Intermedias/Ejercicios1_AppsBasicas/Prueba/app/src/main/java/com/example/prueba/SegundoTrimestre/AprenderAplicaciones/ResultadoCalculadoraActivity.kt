package com.example.prueba.SegundoTrimestre.AprenderAplicaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.prueba.R

class ResultadoCalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_calculadora)

        val tvResult=findViewById<TextView>(R.id.resultado)
        tvResult.text = resultado
    }
}