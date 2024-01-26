package com.example.prueba

fun main(){
    println("Hola mundo")

    var num:Int = 2;
    var palabra:String = "Hola";

    println(""+palabra+" es "+(palabra.isNotEmpty()));

    /* Ejemplo
    println("Ingrese sueldo:");

    val sueldo = readln().toDouble();

    if(sueldo > 3000){
        println("Tienes que pagar la mitad en impuestos.")
    }*/

    /* Ej 1
    println("Dime tu nota:");

    val nota:Float = readln().toFloat();

    if(nota==0f){
        println("Eres un mierda");
    }else if(nota>0 && nota<5){
        println("Estas suspenso");
    }else if(nota>=5 && nota <7){
        println("Tienes un bien");
    }else if(nota >=7 && nota <9){
        println("Tienes un notable");
    }else if(nota >=9){
        println("Tienes un sobresaliente");
    }*/

    /*Ej 2*/
    println("Ingrese 2 numeros:")
    val num1:Float = readln().toFloat();
    val num2: Float? = readLine()?.toFloat();

    if(num1> num2!!){
        println("El mayor es :"+ num1);
    }else if(num2!!>num1){
        println("El mayor es :"+ num2);
    }else{
        println("Son iguales");
    }

}