package com.example.prueba.SegundoTrimestre.AprenderAplicaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.prueba.R

var resultado:String = "0"

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val op1 = findViewById<AppCompatEditText>(R.id.operador1)
        val op2 = findViewById<AppCompatEditText>(R.id.operador2)


        val btnSumar = findViewById<AppCompatButton>(R.id.botonSumar)
        btnSumar.setOnClickListener{
            resultado = ""+(op1.text.toString().toFloat()+op2.text.toString().toFloat())
            setContentView(R.layout.activity_resultado_calculadora)
        }

        val btnRestar = findViewById<AppCompatButton>(R.id.botonRestar)
        btnRestar.setOnClickListener{
            resultado = ""+(op1.text.toString().toFloat()-op2.text.toString().toFloat())
            setContentView(R.layout.activity_resultado_calculadora)
        }

        val btnMultiplicar = findViewById<AppCompatButton>(R.id.botonMultiplicar)
        btnMultiplicar.setOnClickListener{
            resultado = ""+(op1.text.toString().toFloat()*op2.text.toString().toFloat())
            setContentView(R.layout.activity_resultado_calculadora)
        }

        val btnDividir = findViewById<AppCompatButton>(R.id.botonDividir)
        btnDividir.setOnClickListener{
            resultado = ""+(op1.text.toString().toFloat()+op2.text.toString().toFloat())
            setContentView(R.layout.activity_resultado_calculadora)
        }
    }
}