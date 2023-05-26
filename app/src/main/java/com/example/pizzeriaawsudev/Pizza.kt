package com.example.pizzeriaawsudev

data class Pizza(
    val id: Int,
    val name: String,
    val description: String,
    val toppings: List<String>
)
