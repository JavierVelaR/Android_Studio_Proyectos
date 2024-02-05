package funciones

import kotlin.random.Random

    fun nAleatorio():Int{
        var aleatorio = Random.nextInt(1,4)
        //println("El valor es $aleatorio")
        return aleatorio
    }