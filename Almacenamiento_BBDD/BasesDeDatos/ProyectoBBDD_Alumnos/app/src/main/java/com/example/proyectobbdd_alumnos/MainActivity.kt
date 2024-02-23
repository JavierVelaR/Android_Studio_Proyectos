package com.example.proyectobbdd_alumnos

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
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDni = findViewById<EditText>(R.id.etDni)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val etCurso = findViewById<EditText>(R.id.etCurso)
        val tvMuestraAlumno = findViewById<TextView>(R.id.tvMuestraAlumno)

        btnAgregar.setOnClickListener {
            val dbHandler = GestorBD(this, null)
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val dni = etDni.text.toString()
            val edad = etEdad.text.toString().toInt()
            val curso = etCurso.text.toString().toInt()

            val user = Alumno(nombre,apellidos,dni,edad,curso)
            dbHandler.addAlumno(user)
            Toast.makeText(this, "Se agregó a la base de datos a: $nombre", Toast.LENGTH_LONG).show()
            etNombre.setText("")
            etApellidos.setText("")
            etDni.setText("")
            etEdad.setText("")
            etCurso.setText("")
        }

        btnMostrar.setOnClickListener {
            tvMuestraAlumno.text = ""
            val dbHandler = GestorBD(this, null)
            val cursor = dbHandler.getAllAlumnos()

            if (cursor != null) {
                cursor.moveToFirst()
                Log.d("Cursor","Cursor no vacio.")

                while (!cursor.isAfterLast) {
                    Log.d("Cursor","Cursor con datos.")

                    val nombre = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_NAME))
                    val apellidos = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_LASTNAME))
                    val dni = cursor.getString(cursor.getColumnIndex(GestorBD.COLUMN_DNI))
                    val edad = cursor.getInt(cursor.getColumnIndex(GestorBD.COLUMN_AGE))
                    val curso = cursor.getInt(cursor.getColumnIndex(GestorBD.COLUMN_COURSE))
                    tvMuestraAlumno.append("Nombre: $nombre - Apellidos: $apellidos - DNI: $dni - Edad: $edad - Curso: $curso\n")

                    Log.d("Cursor","Siguiente dato.")

                    cursor.moveToNext()
                }
                cursor.close()
            }else{
                Log.d("Cursor","Cursor vacio.")
            }
        }
    }
}
