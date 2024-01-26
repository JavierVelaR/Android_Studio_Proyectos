package com.example.prueba

fun main(){

    for(a in 0..10){
        print("$a ")
    }

    println()

    //step: saltos de valor de b (step 2: de 2 en 2)
    for (b in 0..20 step 2){
        print ("$b ")
    }

    println()

    //down to -> hacia atrás
    for (c in 30 downTo 0 step 3){
        print("$c ")
    }

    println("\nTabla del 5:")

    for (i in 0..10){
        println("5 * $i = " + 5*i)
    }

    println("Tabla del 6:")

    var i=0
    while(i<=10){
        val res = 6*i
        println("6 * $i = $res")
        i++
    }

    println("Tabla del 7:")
    var j=0;
    do{
        val res = 7*j
        println("7 * $j = $res")
        j++
    }while(j<=10)
//___________________________________________________________
    println("Dime la nota de tu examen:")
    val nota:Int? = readlnOrNull()?.toInt();

    when(nota){
        0,1,2,3,4 -> println("Suspenso.")
        5 -> println("Aprobado.")
        6 -> println("Bien.")
        7,8 -> println("Notable.")
        9,10 -> println("Sobresaliente.")
    }

}