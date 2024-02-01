package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val personList = generatePersonList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter
    }

    private fun generatePersonList(): List<Person> {
        return listOf(
            Person("Alberto", "Ruíz", "c/ Manuel Díaz", "Málaga"),
            Person("Juan", "Álvarez", "c/ La Tristeza", "Estepona"),
            Person("Eva", "Sato", "c/ Lágrimas de Arturo", "Madrid"),
            Person("Alberto", "Pérez", "c/ Daniel Vargas", "Latino"),
            Person("Laura", "Estaño", "c/ Herrería", "Poblado Medieval"),
            Person("Cristina", "Quintero", "c/ Quintillo", "Málaga"),
            Person("Isabel", "Díaz", "c/ Diputados Estatales", "Valladolid"),
            Person("Pedro", "Jiménez", "c/ Los Rosarios", "Córdoba"),
            Person("Jose", "Ramírez", "c/ del Rey", "Barcelona"),
            Person("Manuel", "Turizo", "c/ Las Palmas", "Tenerife"),
            Person("Diana", "Cruz", "c/ Mellido", "Nicaragua"),
            )
    }
}