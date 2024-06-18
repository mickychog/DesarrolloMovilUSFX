package com.micky.primerkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examenfinal.backend.ApiResponse
import com.example.examenfinal.backend.BaseDatos
import com.example.examenfinal.backend.WSusuarios
import com.example.examenfinal.backend.WebService
import com.example.examenfinal.backend.usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var textViewResult: TextView
private lateinit var textViewList: TextView
private lateinit var userList: List<usuario>
var listData: List<WSusuarios> = ArrayList<WSusuarios>()
class UsuariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        textViewResult = findViewById(R.id.textViewResultado)
        textViewList = findViewById(R.id.textViewListar)
        val buttGuardar = findViewById<Button>(R.id.buttonGuardar)
        val buttListar = findViewById<Button>(R.id.buttonListar)
        getDataUsuarios()

        buttGuardar.setOnClickListener {
            saveDataToDatabase()
        }

        buttListar.setOnClickListener {
            listDataFromDatabase()
        }

    }

    private fun getDataUsuarios() {
        val URL_WS = "https://gorest.co.in/public-api/"
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_WS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val webServiceApi: WebService = retrofit.create(WebService::class.java)
        val call: Call<ApiResponse> = webServiceApi.getUsuarios()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body() ?: return
                    userList = apiResponse.data.map { usuario(it.id, it.name, it.email, it.gender, it.status) }
                    val userInfoBuilder = StringBuilder()
                    for (usuario in userList) {
                        userInfoBuilder.append("---------------------------------------\n")
                        userInfoBuilder.append("Id: ").append(usuario.id).append("\n")
                        userInfoBuilder.append("Nombre: ").append(usuario.nombre).append("\n")
                        userInfoBuilder.append("Email: ").append(usuario.email).append("\n")
                        userInfoBuilder.append("Genero: ").append(usuario.genero).append("\n")
                        userInfoBuilder.append("Estado: ").append(usuario.estado).append("\n")
                    }

                    // Mostrar la información en el TextView
                    textViewResult.text = userInfoBuilder.toString()
                } else {
                    Toast.makeText(this@UsuariosActivity, "Algo pasó", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, throwable: Throwable) {
                Toast.makeText(
                    this@UsuariosActivity,
                    "REVISE EL SERVICIO WEB DE INTERNET",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun saveDataToDatabase() {
        val dbHandler = BaseDatos(this)
        var success = true
        for (usuario in userList) {
            success = success && dbHandler.addResultado(usuario)
        }
        val mensaje = if (success) {
            "Inserción exitosa"
        } else {
            "No se pudo insertar"
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        Log.d("Sqlite", "--->$mensaje")
    }

    private fun listDataFromDatabase() {
        val dbHandler = BaseDatos(this)
        val storedUsers = dbHandler.d_result
        val userInfoBuilder = StringBuilder()
        for (usuario in storedUsers) {
            userInfoBuilder.append("---------------------------------------\n")
            userInfoBuilder.append("Id: ").append(usuario.id).append("\n")
            userInfoBuilder.append("Nombre: ").append(usuario.nombre).append("\n")
            userInfoBuilder.append("Email: ").append(usuario.email).append("\n")
            userInfoBuilder.append("Genero: ").append(usuario.genero).append("\n")
            userInfoBuilder.append("Estado: ").append(usuario.estado).append("\n")
        }
        textViewList.text = userInfoBuilder.toString()
    }
}