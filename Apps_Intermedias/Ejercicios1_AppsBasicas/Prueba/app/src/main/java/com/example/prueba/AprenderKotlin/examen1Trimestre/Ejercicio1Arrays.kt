package com.example.prueba.AprenderKotlin.examen1Trimestre

fun main(){
    /*
    Creación de la matriz bidimensional con dos arrayOf, uno de String para los nombres, y otro de Double para los salarios
    Los nombres y los salarios son las filas de la matriz modificados con joinToString para más comodidad
     */
    var empleados = arrayOf(arrayOf<String>("Juan", "Eva", "Ana", "Pedro"), arrayOf<Double>(1700.0, 2800.0,1900.0, 2300.0))

    val nombres = empleados[0].joinToString(", ")
    println("Nombres: $nombres")

    val salarios= empleados[1].joinToString(", ")
    println("Salario Base: $salarios")

    //Se itera en cada posición de los salarios sumandolos en una variable, y luego se almacena la media en otra variable
    var suma:Double=0.0
    for(i in empleados[1].iterator()){
        suma += i as Double
    }

    val salarioMedio = suma/empleados[1].size

    println("Salario medio: $salarioMedio")
    println("Salario suma: $suma")

}