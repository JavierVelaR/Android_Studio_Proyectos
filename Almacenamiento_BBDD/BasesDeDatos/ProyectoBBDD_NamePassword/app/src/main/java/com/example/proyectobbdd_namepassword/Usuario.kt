package com.example.proyectobbdd_namepassword

class Usuario {
    var id: Int = 0
    var nombre: String? = null
    var contraseña: String? = null

    constructor(id: Int, nombre: String, contraseña: String) {
        this.id = id
        this.nombre = nombre
        this.contraseña = contraseña
    }

    constructor(nombre: String, contraseña: String) {
        this.nombre = nombre
        this.contraseña = contraseña
    }
}