package com.example.pizzeriaawsudev

import junit.framework.Assert.fail
import org.junit.Assert
import org.junit.Test

class PruebaTest {
    val prueba = Pruebas();

    @Test
    fun deberiaSumarCorrectamente() {
        val suma = prueba.sumar(2, 2)
        Assert.assertEquals(4, suma)
    }

    @Test
    fun deberiaRestarCorrectamente(){
        val resta = prueba.restar(5,2);
        Assert.assertEquals(3,resta);
    }

    @Test
    fun deberiaMultiplicarCorrectamente(){
        val multiplicacion = prueba.multiplicar(6,5)
        Assert.assertEquals(30,multiplicacion)
    }

    @Test
    fun deberiaDividirCorrectament() {
        val result = prueba.dividir(10.0, 2.0)
        Assert.assertEquals(5.0, result,0.0)
    }

    @Test
    fun deberiaLanzarUnaExcepcionAlDividirPorCero() {
        try {
            prueba.dividir(5.0, 0.0)
            fail("Se esperaba que lanzara una ArithmeticException")
        } catch (e: ArithmeticException) {
            Assert.assertEquals("División por cero no está permitida", e.message)
        }
    }

}