package com.example.prueba.AprenderKotlin.examen1Trimestre

fun main(){
    val centro = mutableListOf<Any>("MATEMATICAS", "Manolo", 5, "LENGUA", "Dani", 3)

    //Mostramos la lista original
    println("--- Lista Original ---")
    mostrar(centro)

    //Accedemos a la posición de la lista para modificar su valor, y la mostramos
    centro[0] = "HISTORIA"
    centro[3] = "FISICA"

    println("--- Lista Modificada ---")
    mostrar(centro)

    //Añadimos una nueva asignatura con almuno y nota, y mostramos de nuevo la lista
    centro.add("EDUCACION FISICA")
    centro.add("Antonio")
    centro.add(7)

    println("--- Lista Añadida ---")
    mostrar(centro)
}

fun mostrar(lista:List<Any>){
    //Recorre los elementos de la lista proporcionada
    for(element in lista){
        println(element)
    }
}