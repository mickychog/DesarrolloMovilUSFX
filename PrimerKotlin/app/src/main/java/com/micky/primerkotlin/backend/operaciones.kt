package com.micky.primerkotlin.backend

class Operaciones(private var a: Int, private var b: Int) {

    fun getA(): Int {
        return a
    }

    fun getB(): Int {
        return b
    }

    fun setA(a: Int) {
        this.a = a
    }

    fun setB(b: Int) {
        this.b = b
    }

    fun suma(): Int {
        return this.a + this.b
    }

    fun resta(): Int {
        return this.a - this.b
    }

    fun multiplicacion(): Int {
        return this.a * this.b
    }

    fun division(): Float {
        if (this.b != 0) {
            return this.a.toFloat() / this.b.toFloat()
        } else {
            throw ArithmeticException("No se puede dividir por cero.")
        }
    }

    fun realizarOperacion(operador: String): Int {
        when (operador) {
            "+" -> return suma()
            "-" -> return resta()
            "*" -> return multiplicacion()
            "/" -> return division().toInt()
            else -> throw IllegalArgumentException("Operador no válido")
        }
    }
}
