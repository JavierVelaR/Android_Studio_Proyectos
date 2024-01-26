package funciones

fun fibonacci(rep:Int){
    var ant = 0
    var act = 1
    var sig = 0
    println("0\n1")

    for (i in 0..rep){
        sig = ant + act
        println(sig)
        ant = act
        act = sig

    }
}