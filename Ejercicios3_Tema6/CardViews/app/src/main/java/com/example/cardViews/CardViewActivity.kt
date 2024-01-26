package com.example.cardViews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class CardViewActivity : AppCompatActivity() {

    private lateinit var tvIngresos: TextView
    private val incremento = 100
    private lateinit var opcion :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        val cardView1 = findViewById<CardView>(R.id.cardView1)
        handleCardViewClick(cardView1)

        val cardView2 = findViewById<CardView>(R.id.cardView2)
        handleCardViewClick(cardView2)


        tvIngresos = findViewById<TextView>(R.id.ingresos)

        val btnMenor = findViewById<FloatingActionButton>(R.id.botonMenor)
        btnMenor.setOnClickListener{
            disminuir()
        }

        val btnMayor = findViewById<FloatingActionButton>(R.id.botonMayor)
        btnMayor.setOnClickListener{
            aumentar()
        }


        val rangeSlider = findViewById<RangeSlider>(R.id.rsEdad)
        val edad = findViewById<TextView>(R.id.edad)

        rangeSlider.addOnChangeListener{ slider, value, fromUser ->
            edad.text = "${value.toInt()} años"
        }

        val botonAceptar = findViewById<AppCompatButton>(R.id.acepta)
        botonAceptar.setOnClickListener{
            val ingresos = tvIngresos.text.toString()
            val edad = rangeSlider.values[0].toInt()

            //Crear un Intent para pasar a la segunda actividad
            val intent = Intent(this, SecondActivity::class.java)

            if(opcion.isNullOrBlank())opcion = "Ninguna"

            //Agregar datos extra al Intent
            intent.putExtra("ingresos", ingresos)
            intent.putExtra("edad", edad)
            intent.putExtra("opcion", opcion)

            //Iniciar segunda actividad
            startActivity(intent)
        }

    }

    fun aumentar(){
        val valorActual = tvIngresos.text.toString().toInt()
        val nuevoValor = valorActual + incremento

        if(nuevoValor<=Int.MAX_VALUE) tvIngresos.text = nuevoValor.toString()
    }

    fun disminuir(){
        val valorActual = tvIngresos.text.toString().toInt()
        val nuevoValor = valorActual - incremento

        if(nuevoValor>=0) tvIngresos.text = nuevoValor.toString()
    }

    fun handleCardViewClick(cardView:CardView){
        when(cardView.id){
            R.id.cardView1 ->{
                println("Se ha pulsado el cardView1")
                Log.d("CardView1", "handleCardViewClick: pulsado cardView1")
                opcion = "CardView1"
            }
            R.id.cardView2->{
                println("Se ha pulsado el cardView2")
                Log.d("CardView2", "handleCardViewClick: pulsado cardView2")
                opcion = "CardView2"
            }
        }
    }

}