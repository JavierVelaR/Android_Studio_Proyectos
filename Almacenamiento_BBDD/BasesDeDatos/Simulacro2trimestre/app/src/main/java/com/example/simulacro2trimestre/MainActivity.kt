package com.example.simulacro2trimestre

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etCp = findViewById<EditText>(R.id.etCp)
        val etCiudad = findViewById<EditText>(R.id.etCiudad)
        val etProvincia = findViewById<EditText>(R.id.etProvincia)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val tvMuestraDatos = findViewById<TextView>(R.id.tvMuestraDatos)

        btnAgregar.setOnClickListener {
            val dbHandler = GestorDB(this, null)
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val direccion = etDireccion.text.toString()
            val cp = etCp.text.toString()
            val ciudad = etCiudad.text.toString()
            val provincia = etProvincia.text.toString()
            val telefono = etTelefono.text.toString().toInt()

            val datos = DatosPersonales(nombre, apellidos, direccion, cp, ciudad, provincia, telefono)
            dbHandler.addData(datos)
            Toast.makeText(
                this,
                "Se agregó a la base de datos a: $nombre",
                Toast.LENGTH_LONG
            ).show()
            etNombre.setText("")
            etApellidos.setText("")
            etDireccion.setText("")
            etCp.setText("")
            etCiudad.setText("")
            etProvincia.setText("")
            etTelefono.setText("")
        }

        btnBorrar.setOnClickListener {
            val dbHandler = GestorDB(this, null)
            val nombre = etNombre.text.toString()
            dbHandler.removeData()

        }

        btnMostrar.setOnClickListener {
            tvMuestraDatos.text = ""
            val dbHandler = GestorDB(this, null)
            val cursor = dbHandler.getAllData()

            if (cursor != null) {
                cursor.moveToFirst()
                while (!cursor.isAfterLast) {
                    val nombre = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_NAME))
                    val apellidos = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_LASTNAME))
                    val direccion = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_ADDRESS))
                    val cp = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_CP))
                    val ciudad = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_CITY))
                    val provincia = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_PROVINCIA))
                    val telefono = cursor.getString(cursor.getColumnIndex(GestorDB.COLUMN_TELEFONO))
                    tvMuestraDatos.append("Nombre: $nombre - Apellidos: $apellidos\n")
                    cursor.moveToNext()
                }
                cursor.close()
            }
        }
    }
}
