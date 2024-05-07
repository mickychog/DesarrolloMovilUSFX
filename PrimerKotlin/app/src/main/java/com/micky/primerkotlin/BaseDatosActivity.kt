package com.micky.primerkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.micky.primerkotlin.backend.BaseDatos
import com.micky.primerkotlin.backend.Lugares


class BaseDatosActivity : AppCompatActivity() {
    private lateinit var buttonCrear: Button
    private lateinit var buttonMostrar: Button
    private lateinit var buttonUpdate: Button
    private lateinit var buttonDelete: Button
    private lateinit var buttonSalir: Button

    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)

        buttonCrear = findViewById(R.id.buttonCrear)
        buttonMostrar = findViewById(R.id.buttonMostrar)
        buttonUpdate = findViewById(R.id.buttonUpdate)
        buttonDelete = findViewById(R.id.buttonDelete)
        buttonSalir = findViewById(R.id.buttonSalir)

        dbHandler = BaseDatos(this)

//        var success: Boolean = false
//        val lugares: Lugares = Lugares()
//        lugares.nombre = "nombre1"
//        lugares.descripcion = "descripcion1"
//        lugares.latitud = 1.3f
//        lugares.longitud = 2.4f
//        success = dbHandler?.addLugar(lugares) as Boolean
//
//        // Mostrar Toast si se agregó correctamente
//        if (success) {
//            Toast.makeText(this, "Lugar agregado: ${lugares.nombre}", Toast.LENGTH_SHORT).show()
//        }
//
//        Log.d("Datos","--->" + success.toString())
//
//        success = false
//        val lugares1: Lugares = Lugares()
//        lugares1.nombre = "nombre2"
//        lugares1.descripcion = "descripcion2"
//        lugares1.latitud = 1.3f
//        lugares1.longitud = 2.4f
//        success = dbHandler?.addLugar(lugares1) as Boolean
//
//        if (success) {
//            Toast.makeText(this, "Lugar agregado: ${lugares1.nombre}", Toast.LENGTH_SHORT).show()
//        }
//
//        listTasks = (dbHandler as BaseDatos).lugar
//
//        Log.d("Datos","--->" + listTasks[0].nombre)
//        for(lugares in listTasks){
//            Log.d("Datos","--->" + lugares.nombre)
//        }
//
//        success = false
//        val lugares2: Lugares = Lugares()
//        lugares2.id = 1 //Voy a actualizar este registro
//        lugares2.nombre = "nombreX"
//        lugares2.descripcion = "descripcionX"
//        lugares2.latitud = 1.3f
//        lugares2.longitud = 2.4f
//        success = dbHandler?.updateLugar(lugares2) as Boolean
//
//        success = false
//        success = dbHandler?.deleteLugar(1) as Boolean
//
//        listTasks = (dbHandler as BaseDatos).lugar
//        Log.d("Datos","--->" + listTasks)




        buttonCrear.setOnClickListener {
            val intent = Intent(this, CrearActivity::class.java)
            startActivity(intent)
        }

        buttonMostrar.setOnClickListener {
            val intent = Intent(this, MostrarActivity::class.java)
            startActivity(intent)
        }

        buttonSalir.setOnClickListener { finish() }
    }
}
