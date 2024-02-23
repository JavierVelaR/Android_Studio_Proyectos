package com.example.simulacro2trimestre

class DatosPersonales {
    var id: Int = 0
    var nombre: String? = null
    var apellidos: String? = null
    var direccion: String? = null
    var cp: String? = null
    var ciudad: String? = null
    var provincia: String? = null
    var telefono: Int = 0

    constructor(id: Int, nombre: String?, apellidos: String, direccion: String?, cp: String?, ciudad: String?, provincia: String?, telefono: Int) {
        this.id = id
        this.nombre = nombre
        this.apellidos = apellidos
        this.direccion = direccion
        this.cp = cp
        this.ciudad = ciudad
        this.provincia = provincia
        this.telefono = telefono
    }

    constructor(nombre: String?, apellidos: String, direccion: String?, cp: String?, ciudad: String?, provincia: String?, telefono: Int) {
        this.id = id
        this.nombre = nombre
        this.apellidos = apellidos
        this.direccion = direccion
        this.cp = cp
        this.ciudad = ciudad
        this.provincia = provincia
        this.telefono = telefono
    }

}