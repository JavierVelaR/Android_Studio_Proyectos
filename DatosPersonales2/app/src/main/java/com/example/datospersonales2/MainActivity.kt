package com.example.datospersonales2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etAutor = findViewById<EditText>(R.id.etAutor)
        val etGenero = findViewById<EditText>(R.id.etGenero)
        val etEditorial = findViewById<EditText>(R.id.etEditorial)
        val etAnio = findViewById<EditText>(R.id.etAnio)
        val tvMuestraAlumno = findViewById<TextView>(R.id.tvMuestraAlumno)

        btnAgregar.setOnClickListener {
            val dbHandler = GestorBD(this, null)
            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()
            val genero = etGenero.text.toString()
            val editorial = etEditorial.text.toString()
            val anio = etAnio.text.toString().toInt()

            val libro = Libros(titulo,autor,genero,editorial,anio)
            dbHandler.addLibro(libro)
            Toast.makeText(this, "Se agregó a la base de datos a: $titulo", Toast.LENGTH_LONG).show()
            etTitulo.setText("")
            etAutor.setText("")
            etGenero.setText("")
            etEditorial.setText("")
            etAnio.setText("")
        }

        btnMostrar.setOnClickListener {
            tvMuestraAlumno.text = ""
            val dbHandler = GestorBD(this, null)
            val cursor = dbHandler.getAllLibros()

            if (cursor != null) {
                cursor.moveToFirst()
                Log.d("Cursor","Cursor no vacio.")

                while (!cursor.isAfterLast) {
                    Log.d("Cursor","Cursor con datos.")

                    val titulo = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_TITTLE))
                    val autor = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_AUTOR))
                    val genero = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_GENRE))
                    val editorial = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_EDITORIAL))
                    val anio = cursor.getInt(cursor.getColumnIndex(GestorBD.COLUMN_YEAR))
                    tvMuestraAlumno.append("Titulo: $titulo - Autor: $autor - Genero: $genero - Editorial: $editorial - Año: $anio\n")

                    Log.d("Cursor","Siguiente dato.")

                    cursor.moveToNext()
                }
                cursor.close()
            }else{
                Log.d("Cursor","Cursor vacio.")
            }
        }

        btnBorrar.setOnClickListener {
            val dbHandler = GestorBD(this, null)
            dbHandler.borrarDatos()
        }
    }
}