package com.example.prueba.AprenderKotlin.examen1Trimestre

interface Jugable{
    fun jugar(nombreUsuario: String)
}

interface SonidoAmbiente{
    fun reproducirSonido()
}

interface GuardadoPartida{
    fun guardarPartida()
}

class Aventura(var nombre:String):Jugable, SonidoAmbiente, GuardadoPartida{
    override fun jugar(nombre:String){
        println("Bienvenido a la aventura $nombre.")
    }

    override fun reproducirSonido() {
        println("...Se escuchan animales acechándote desde matorrales...")
    }

    override fun guardarPartida() {
        println("Partida guardada, no te preocupes.")
    }
}

class Deportes(var nombre:String):Jugable, SonidoAmbiente, GuardadoPartida{
    override fun jugar(nombre:String){
        println("Bienvenido a la carrera, $nombre.")
    }

    override fun reproducirSonido() {
        println("...Se escucha el público animando al estadio...")
    }

    override fun guardarPartida() {
        println("Tu posición ha sido guardada, puedes rendirte.")
    }
}

class Estrategia(var nombre:String):Jugable, SonidoAmbiente, GuardadoPartida{
    override fun jugar(nombre:String){
        println("Bienvenido $nombre, espero que tengas un buen coco.")
    }

    override fun reproducirSonido() {
        println("...Música de pensar...")
    }

    override fun guardarPartida() {
        println("Movimiento guardado.")
    }
}

fun main(){
    val amazonas = Aventura("Amazonas")
    val atletismo = Deportes("Atletismo")
    val ajedrez = Estrategia("Ajedrez")

    amazonas.jugar("Viajero del tiempo")
    amazonas.reproducirSonido()
    amazonas.guardarPartida()
    println()

    atletismo.jugar("Rosenberg de Cenec")
    atletismo.reproducirSonido()
    atletismo.guardarPartida()
    println()

    ajedrez.jugar("Visionario mundial")
    ajedrez.reproducirSonido()
    ajedrez.guardarPartida()
}