package com.example.prueba.AprenderKotlin.examen1Trimestre

//Clase padre, con nombre y tipo de terreno
open class Deporte(val nombre:String, val tipoTerreno:String){

    open fun mostrarDetalles(){
            println("Nombre: $nombre\nTipo de terreno: $tipoTerreno")
    }
}

//4 clases hijas, con los 2 atributos del padre más 2 específicos de cada una
class Futbol (nombre: String, tipoTerreno: String, var numeroJugadores:Int, var esCampoGrande:Boolean): Deporte(nombre, tipoTerreno)  {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Número de jugadores: $numeroJugadores\nEl campo es grande? $esCampoGrande")
    }
}

class Baloncesto(nombre: String, tipoTerreno: String, var alturaCanasta: Double, var esDeporteEquipo: Boolean): Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Altura de la canasta: $alturaCanasta\nEs deporte de equipo? $esDeporteEquipo")
    }
}

class Balonmano(nombre: String, tipoTerreno: String, var esDeporteOlimpico: Boolean, var esContacto: Boolean): Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Es deporte olímpico? $esDeporteOlimpico\nEs deporte de contacto? $esContacto")
    }
}

class Voleibol(nombre: String, tipoTerreno: String, var esDeportePlaya: Boolean, var numeroJugadoresEquipo: Int ): Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Es deporte de playa? $esDeportePlaya\nNúmero de jugadores por equipo: $numeroJugadoresEquipo")
    }
}

fun main(){
    //Instanciamos un deporte de cada, dándole valor a sus atributos en el constructor
    val furbo = Futbol("Fútbol", "Césped", 11,true)
    val baloncesto = Baloncesto("Fútbol", "Cemento", 2.35,true)
    val balonmano = Balonmano("Fútbol", "Cemento", true,true)
    val voleibol = Voleibol("Fútbol", "Arena/P", true,3)

    //Llamamos a su función de mostrar detalles de cada clase hija, con un println para dejar una línea en blanco
    furbo.mostrarDetalles()
    println()
    baloncesto.mostrarDetalles()
    println()
    balonmano.mostrarDetalles()
    println()
    voleibol.mostrarDetalles()
}