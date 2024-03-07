package com.example.datospersonales

class Libro {
    var id: Int = 0
    var titulo: String? = null
    var autor: String? = null
    var genero: String? = null
    var editorial: String? = null
    var anio: Int = 0

    constructor(id: Int, titulo: String, autor: String, genero: String, editorial: String, anio: Int) {
        this.id = id
        this.titulo = titulo
        this.autor = autor
        this.genero = genero
        this.editorial = editorial
        this.anio = anio
    }

    constructor(titulo: String, autor: String, genero: String, editorial: String, anio: Int) {
        this.titulo = titulo
        this.autor = autor
        this.genero = genero
        this.editorial = editorial
        this.anio = anio
    }
}