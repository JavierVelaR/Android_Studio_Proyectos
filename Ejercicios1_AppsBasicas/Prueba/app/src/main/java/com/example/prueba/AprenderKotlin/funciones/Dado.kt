package funciones

class Dado (var valor:Int){

    public fun jugar(){
        val dado1 = Dado(6)
        val dado2 = Dado(6)
        val dado3 = Dado(6)

        dado1.tirarDado()
        dado2.tirarDado()
        dado3.tirarDado()

        if(dado1.valor==dado2.valor && dado1.valor== dado3.valor){
            println("Has ganado")
        }else{
            println("Has perdido")
        }
    }

    fun tirarDado (){
        valor = (Math.random()*6 +1).toInt()
        imprimir()
    }

    fun imprimir(){
        println("Ha salido el valor $valor")
    }

}