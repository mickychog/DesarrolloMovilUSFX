package com.micky.primerkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.micky.primerkotlin.backend.BaseDatos
import com.micky.primerkotlin.backend.Lugares

class UpdateActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var etLatitud: EditText
    private lateinit var etLongitud: EditText
    private lateinit var btnActualizar: Button
    private lateinit var btnVolver: Button
    private lateinit var dbHandler: BaseDatos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        etNombre = findViewById(R.id.etNombre)
        etDescripcion = findViewById(R.id.etDescripcion)
        etLatitud = findViewById(R.id.etLatitud)
        etLongitud = findViewById(R.id.etLongitud)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnVolver = findViewById(R.id.btnVolver)
        dbHandler = BaseDatos(this)

        val lugarId = intent.getIntExtra("lugar_id", -1)
        if (lugarId != -1) {
            val lugar = dbHandler.getLugar(lugarId)
            etNombre.setText(lugar.nombre)
            etDescripcion.setText(lugar.descripcion)
            etLatitud.setText(lugar.latitud.toString())
            etLongitud.setText(lugar.longitud.toString())
        }

        btnActualizar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val descripcion = etDescripcion.text.toString()
            val latitud = etLatitud.text.toString().toFloatOrNull()
            val longitud = etLongitud.text.toString().toFloatOrNull()

            if (latitud == null || longitud == null) {
                Toast.makeText(this, "Ingrese valores válidos para latitud y longitud", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val lugar = Lugares()
            lugar.id = lugarId
            lugar.nombre = nombre
            lugar.descripcion = descripcion
            lugar.latitud = latitud
            lugar.longitud = longitud

            val success = dbHandler.updateLugar(lugar)
            if (success) {
                Toast.makeText(this, "Lugar actualizado correctamente", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
                finish()
            } else {
                Toast.makeText(this, "Error al actualizar el lugar", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}
