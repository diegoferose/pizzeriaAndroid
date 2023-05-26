package com.example.pizzeriaawsudev

import retrofit2.Call
import retrofit2.http.GET

interface PizzaApi {
    @GET("pizzas")
    fun getPizzas(): Call<List<Pizza>>
}