package com.example.ficheros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class RetoFicherosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_ficheros)

        val etNombre = findViewById<EditText>(R.id.campoNombre)
        val etContenido = findViewById<EditText>(R.id.campoContenido)

        val btnCrearArchivo: Button = findViewById(R.id.btnCrearArchivo)

        btnCrearArchivo.setOnClickListener {
            crearArchivo(etNombre.text.toString(), etContenido.text.toString())
        }

        val nombreLeer = findViewById<EditText>(R.id.campoNombreLeer)
        val tvContenido = findViewById<TextView>(R.id.tvContenido)

        val btnLeerArchivo: Button = findViewById(R.id.btnLeerArchivo)
        btnLeerArchivo.setOnClickListener {
            leerArchivo(tvContenido, nombreLeer.text.toString())
        }

    }

    private fun crearArchivo(nombre:String, contenido:String) {
        try {
            // Abrir un OutputStreamWriter en el modo privado (solo accesible por esta aplicación)
            var osw: OutputStreamWriter = OutputStreamWriter(openFileOutput(nombre, MODE_PRIVATE))

            // Escribir el contenido en el archivo
            osw.write(contenido)

            // Limpiar y cerrar el OutputStreamWriter
            osw.flush() //limpiamos
            osw.close() //cerramos

            Log.d("Éxito", "Archivo creado con éxito!")
        } catch (e: Exception) {
            Log.e("Error", "Error al usar OutputStreamWriter: " + e.message)
        }
    }

    private fun leerArchivo(tv : TextView, nombre:String) {
        try {
            // Abrir un BufferedReader para leer el archivo
            val br = BufferedReader(InputStreamReader(openFileInput(nombre)))

            // Leer la primera línea del archivo
            val texto = br.readLine()

            //Mostrar el texto en el TextView del argumento
            tv.text = texto

            // Cerrar el BufferedReader
            br.close()

            Log.d("Éxito", "Contenido del archivo: $texto")


        } catch (e: Exception) {
            Log.e("Error", "Error al leer el archivo: " + e.message)
        }
    }
}