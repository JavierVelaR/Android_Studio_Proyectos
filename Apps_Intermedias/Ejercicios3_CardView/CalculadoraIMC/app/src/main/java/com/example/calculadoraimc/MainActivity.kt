package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var txtAltura:TextView
    lateinit var txtPeso:TextView
    lateinit var txtEdad:TextView
    lateinit var genero:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAltura = findViewById<TextView>(R.id.textoAltura)
        txtPeso = findViewById<TextView>(R.id.textoPeso)
        txtEdad = findViewById<TextView>(R.id.textoEdad)

        //CardViews genero
        val hombre = findViewById<CardView>(R.id.hombre)
        handleCardViewClick(hombre)
        val mujer = findViewById<CardView>(R.id.mujer)
        handleCardViewClick(mujer)

        //RangeSlider altura
        val rsAltura = findViewById<RangeSlider>(R.id.rsAltura)
        rsAltura.addOnChangeListener{ slider, value, fromUser ->
            txtAltura.text = "${value.toInt()}"
        }

        //Botones peso
        val btnMenosPeso = findViewById<FloatingActionButton>(R.id.btnMenosPeso)
        btnMenosPeso.setOnClickListener{
            disminuirPeso()
        }

        val btnMasPeso = findViewById<FloatingActionButton>(R.id.btnMasPeso)
        btnMasPeso.setOnClickListener{
            aumentarPeso()
        }

        //Botones edad
        val btnMenosEdad = findViewById<FloatingActionButton>(R.id.btnMenosEdad)
        btnMenosEdad.setOnClickListener{
            disminuirEdad()
        }

        val btnMasEdad = findViewById<FloatingActionButton>(R.id.btnMasEdad)
        btnMasEdad.setOnClickListener{
            aumentarEdad()
        }

        val btnCalcular = findViewById<AppCompatButton>(R.id.calcular)
        btnCalcular.setOnClickListener {
            val alt: Double = rsAltura.values[0].toInt().toDouble()/100
            val peso = txtPeso.text.toString().toInt()
            var res: String = "Indefinido"
            var txt: String = "..."

            val resIMC: Double = ((peso / (alt * alt))*100).roundToInt()/100.0

            if (resIMC < 18.5) {
                res = "Bajo peso"
                txt = "Estás por debajo de tu peso y altura ideales"
            } else if (resIMC in 18.5..24.99) {
                res = "Peso normal"
                txt = "Estás en tu peso y altura ideales"
            } else if (resIMC in 25.0..29.99) {
                res = "Sobrepeso"
                txt = "Estás por encima de tu peso y altura ideales"
            } else if (resIMC > 30.0) {
                res = "Obesidad"
                txt = "Estás muy por encima de tu peso y altura ideales"
            }

            //Crear un Intent para pasar a la segunda actividad
            val intent = Intent(this, SecondActivity::class.java)

            //Agregar datos extra al Intent
            intent.putExtra("ResultadoIMC", resIMC)
            intent.putExtra("Resultado", res)
            intent.putExtra("ResultadoTexto", txt)

            //Iniciar segunda actividad
            startActivity(intent)
        }
    }

    private fun handleCardViewClick(cv:CardView){
        when(cv.id){
            R.id.hombre ->{
                println("Se ha seleccionado: Hombre")
                Log.d("Hombre", "handleCardViewClick: seleccionado Hombre")
                genero = "Hombre"
            }
            R.id.mujer->{
                println("Se ha seleccionado: Hombre")
                Log.d("Mujer", "handleCardViewClick: seleccionado Mujer")
                genero = "Mujer"
            }
        }
    }


    private fun aumentarPeso(){
        val valorActual = txtPeso.text.toString().toInt()
        val nuevoValor = valorActual + 1

        txtPeso.text = "$nuevoValor"
    }

    private fun disminuirPeso(){
        val valorActual = txtPeso.text.toString().toInt()
        val nuevoValor = valorActual - 1

        txtPeso.text = "$nuevoValor"
    }

    private fun aumentarEdad(){
        val valorActual = txtEdad.text.toString().toInt()
        val nuevoValor = valorActual + 1

        txtEdad.text = nuevoValor.toString()
    }

    private fun disminuirEdad(){
        val valorActual = txtEdad.text.toString().toInt()
        val nuevoValor = valorActual - 1

        txtEdad.text = nuevoValor.toString()
    }

}