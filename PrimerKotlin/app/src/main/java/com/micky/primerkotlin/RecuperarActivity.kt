package com.micky.primerkotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecuperarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        val textViewUsers = findViewById<TextView>(R.id.textViewUsers)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.getUsuarios()

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val users = response.body()?.data ?: emptyList()
                    val userText = users.joinToString(separator = "\n\n") { user ->
                        "ID: ${user.id}\nNombre: ${user.name}\nEmail: ${user.email}\nGenero: ${user.gender}\nEstado: ${user.status}"
                    }
                    textViewUsers.text = userText
                } else {
                    Log.e("RecuperarActivity", "Error en la respuesta: ${response.code()}")
                    textViewUsers.text = "Error en la respuesta: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("RecuperarActivity", "Error en la llamada a la API", t)
                textViewUsers.text = "Error en la llamada a la API: ${t.message}"
            }
        })
    }
}
