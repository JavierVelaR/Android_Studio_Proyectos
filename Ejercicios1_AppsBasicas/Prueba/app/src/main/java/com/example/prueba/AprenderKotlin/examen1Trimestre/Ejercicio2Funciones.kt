package com.example.prueba.AprenderKotlin.examen1Trimestre

import kotlin.random.Random

//Declaración de las victorias, derrotas y las opciones; para poder acceder a ellas desde cualquier método
var victorias:Int = 0
var derrotas:Int = 0
val opciones = arrayOf("piedra", "papel", "tijeras")

fun main(){
    println("Bienvenido a Piedra, Papel o Tijeras.")
    println("Dime cuántas paridas vas a jugar: ")
    val partidas:Int = readln().toInt()

    //Llama a la función jugar las veces que el usuario haya escrito
    for(i in 1..partidas){
        println("--- Partida $i ---")
        jugar()
    }

    println("Partidas ganadas por el usuario: $victorias\nPartidas ganadas por la máquina: $derrotas")
}

fun jugar(){
    print("Usuario elige: ")
    val eleccion = readln()

    //Se selecciona una opción random de las 3 al principio
    val eleccionMaquina = opciones[Random.nextInt(opciones.size)]
    println("Máquina elige: $eleccionMaquina")


    //Se compara el ganador en cada caso, y se suma una victoria más en caso de ganar, y una derrota en caso de perder.
    if(eleccion.equals(opciones[0]) && eleccionMaquina == opciones[2] || eleccion.equals(opciones[1]) && eleccionMaquina == opciones[0] ||
        eleccion.equals(opciones[2]) && eleccionMaquina == opciones[1]){
        victorias++
        println("Resultado: El usuario gana.")

    }else if(eleccion.equals(opciones[0]) && eleccionMaquina == opciones[1] || eleccion.equals(opciones[1]) && eleccionMaquina == opciones[2] ||
        eleccion.equals(opciones[2]) && eleccionMaquina == opciones[0]){
        derrotas++
        println("Resultado: La máquina gana.")

    }else{
        println("Resultado: Ha habido empate.")
    }
}