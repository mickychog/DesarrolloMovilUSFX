package com.micky.primerkotlin


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.micky.primerkotlin.backend.BaseDatos
import com.micky.primerkotlin.backend.Lugares
import android.content.Intent


class CrearActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var etLatitud: EditText
    private lateinit var etLongitud: EditText
    private lateinit var btnAgregar: Button
    private lateinit var btnMostrar: Button
    private lateinit var dbHandler: BaseDatos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)

        etNombre = findViewById(R.id.etNombre)
        etDescripcion = findViewById(R.id.etDescripcion)
        etLatitud = findViewById(R.id.etLatitud)
        etLongitud = findViewById(R.id.etLongitud)
        btnAgregar = findViewById(R.id.btnAgregar)
        btnMostrar = findViewById(R.id.btnMostrar)
        dbHandler = BaseDatos(this)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val descripcion = etDescripcion.text.toString().trim()
            val latitud = etLatitud.text.toString().trim().toFloatOrNull() ?: 0.0f
            val longitud = etLongitud.text.toString().trim().toFloatOrNull() ?: 0.0f

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val lugar = Lugares()
                lugar.nombre = nombre
                lugar.descripcion = descripcion
                lugar.latitud = latitud
                lugar.longitud = longitud

                val success = dbHandler.addLugar(lugar)
                if (success) {
                    Toast.makeText(this, "Lugar correctamente agregado", Toast.LENGTH_SHORT).show()
                    // Limpia los EditTexts después de agregar el lugar exitosamente
                    etNombre.text.clear()
                    etDescripcion.text.clear()
                    etLatitud.text.clear()
                    etLongitud.text.clear()
                } else {
                    Toast.makeText(this, "Error al agregar el lugar", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnMostrar.setOnClickListener {
            val intent = Intent(this, MostrarActivity::class.java)
            startActivity(intent)
        }
    }
}
