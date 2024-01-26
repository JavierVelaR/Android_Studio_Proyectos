package funciones

import kotlin.random.Random

fun piedraPapelTijera(num:Int){
    println("Elige:\n1 - Piedra\n2 - Papel\n3 - Tijera")
    val eleccion:Int? = readln().toIntOrNull()

    when(eleccion) {
        1 -> println("Has elegido Piedra")

        2 -> println("Has elegido Papel")

        3 -> println("Has elegido Tijera")
    }

    when(num) {
        1 -> println("El enemigo ha elegido Piedra")

        2 -> println("El enemigo ha elegido Papel")

        3 -> println("El enemigo ha elegido Tijera")
    }

    if(eleccion==1 && num==2 || eleccion==2 && num==3 || eleccion==3 && num==1){
        println("Has perdido")
    }else if(eleccion==num){
        println("Habeis empatado")
    }else{
        println("Has ganado")
    }

}
