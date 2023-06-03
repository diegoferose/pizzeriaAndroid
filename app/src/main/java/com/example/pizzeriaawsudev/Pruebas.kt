package com.example.pizzeriaawsudev

class Pruebas {
    fun sumar(numero1: Int, numero2: Int): Int {
        return numero1 + numero2
    }

    fun restar(numero1: Int, numero2: Int): Int {
        return numero1 - numero2
    }

    fun multiplicar(numero1: Int, numero2: Int): Int {
        return numero1 * numero2
    }

    fun dividir(numero1: Double, numero2: Double): Double {
        if (numero2 == 0.0) {
            throw ArithmeticException("División por cero no está permitida")
        }
        return numero1 / numero2
    }
}