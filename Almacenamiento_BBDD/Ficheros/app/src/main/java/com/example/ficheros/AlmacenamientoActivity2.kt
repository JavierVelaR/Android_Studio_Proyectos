package com.example.ficheros

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import java.io.BufferedReader
import java.io.InputStreamReader

class AlmacenamientoActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento2)

        val tvContenido = findViewById<TextView>(R.id.tvContenido)

        val btnLeerArchivo: AppCompatButton = findViewById(R.id.btnLeerArchivo)

        btnLeerArchivo.setOnClickListener {
            leerArchivo(tvContenido)
        }
    }

    private fun leerArchivo(tv : TextView) {
        try {
            val fileName = "Segundo fichero"

            // Abrir un BufferedReader para leer el archivo
            val br = BufferedReader(InputStreamReader(openFileInput(fileName)))

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
