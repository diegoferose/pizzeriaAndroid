package com.example.pizzeriaawsudev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val pizzaApi = retrofit.create(PizzaApi::class.java)
        pizzaApi.getPizzas().enqueue(object : Callback<List<Pizza>> {
            override fun onResponse(
                call: Call<List<Pizza>>,
                response: Response<List<Pizza>>
            ) {
                if (response.isSuccessful) {
                    val pizzas = response.body()
                    if (pizzas != null) {
                        for (pizza in pizzas) {
                            println("pizza:")
                            println(pizza.name)
                        }
                    }

                } else {
                    // Error en la llamada
                }
            }

            override fun onFailure(call: Call<List<Pizza>>, t: Throwable) {
                Log.e("ERROR:", "Error en la llamada Retrofit", t)
            }
        }

        )

    }
}