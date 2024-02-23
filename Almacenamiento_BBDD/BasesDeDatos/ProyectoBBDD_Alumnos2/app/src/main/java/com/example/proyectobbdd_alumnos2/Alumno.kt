package com.example.proyectobbdd_alumnos2

class Alumno {
    var id: Int = 0
    var nombre: String? = null
    var apellidos: String? = null
    var dni: String? = null
    var edad: Int = 0
    var curso: Int = 0

    constructor(id: Int, nombre: String, apellidos: String, dni: String, edad: Int, curso: Int) {
        this.id = id
        this.nombre = nombre
        this.apellidos = apellidos
        this.dni = dni
        this.edad = edad
        this.curso = curso
    }

    constructor(nombre: String, apellidos: String, dni: String, edad: Int, curso: Int) {
        this.id = id
        this.nombre = nombre
        this.apellidos = apellidos
        this.dni = dni
        this.edad = edad
        this.curso = curso
    }
}