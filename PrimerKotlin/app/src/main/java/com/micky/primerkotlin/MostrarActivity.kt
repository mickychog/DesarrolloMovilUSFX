package com.micky.primerkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.micky.primerkotlin.R
import com.micky.primerkotlin.UpdateActivity
import com.micky.primerkotlin.backend.BaseDatos
import com.micky.primerkotlin.backend.Lugares

class MostrarActivity : AppCompatActivity() {
    private lateinit var tableLayout: TableLayout
    private lateinit var dbHandler: BaseDatos

    private val UPDATE_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)

        tableLayout = findViewById(R.id.tableLayout)
        dbHandler = BaseDatos(this)
        val lugares: List<Lugares> = dbHandler.lugar

        // Agregar una fila para cada lugar
        for (lugar in lugares) {
            val tableRow = TableRow(this)

            val idTextView = TextView(this)
            idTextView.text = lugar.id.toString()
            tableRow.addView(idTextView)

            val nombreTextView = TextView(this)
            nombreTextView.text = lugar.nombre
            tableRow.addView(nombreTextView)

            val descripcionTextView = TextView(this)
            descripcionTextView.text = lugar.descripcion
            tableRow.addView(descripcionTextView)

            val editarButton = Button(this)
            editarButton.text = "Editar"
            // Agrega un listener de clic para el botón de editar
            editarButton.setOnClickListener {
                editarLugar(lugar)
            }
            tableRow.addView(editarButton)

            val eliminarButton = Button(this)
            eliminarButton.text = "Eliminar"
            // Agrega un listener de clic para el botón de eliminar
            eliminarButton.setOnClickListener {
                mostrarConfirmacionEliminar(lugar)
            }
            tableRow.addView(eliminarButton)

            // Agrega la fila a la tabla
            tableLayout.addView(tableRow)
        }

    }

    private fun editarLugar(lugar: Lugares) {
        val intent = Intent(this, UpdateActivity::class.java)
        intent.putExtra("lugar_id", lugar.id)
        startActivityForResult(intent, UPDATE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == UPDATE_REQUEST_CODE && resultCode == RESULT_OK) {
            actualizarVista()
        }
    }

    private fun mostrarConfirmacionEliminar(lugar: Lugares) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar lugar")
            .setMessage("¿Estás seguro de que quieres eliminar este lugar?")
            .setPositiveButton("Sí") { _, _ ->
                // Eliminar el lugar de la base de datos
                val eliminado = dbHandler.deleteLugar(lugar.id)
                if (eliminado) {
                    // Si se eliminó correctamente, actualiza la vista
                    actualizarVista()
                }
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun actualizarVista() {
        // Limpia la tabla
        tableLayout.removeAllViews()

        // Vuelve a cargar los lugares y rellena la tabla nuevamente
        val lugares: List<Lugares> = dbHandler.lugar
        for (lugar in lugares) {
            val tableRow = TableRow(this)

            val idTextView = TextView(this)
            idTextView.text = lugar.id.toString()
            tableRow.addView(idTextView)

            val nombreTextView = TextView(this)
            nombreTextView.text = lugar.nombre
            tableRow.addView(nombreTextView)

            val descripcionTextView = TextView(this)
            descripcionTextView.text = lugar.descripcion
            tableRow.addView(descripcionTextView)

            val editarButton = Button(this)
            editarButton.text = "Editar"
            // Agrega un listener de clic para el botón de editar
            editarButton.setOnClickListener {
                editarLugar(lugar)
            }
            tableRow.addView(editarButton)

            val eliminarButton = Button(this)
            eliminarButton.text = "Eliminar"
            // Agrega un listener de clic para el botón de eliminar
            eliminarButton.setOnClickListener {
                mostrarConfirmacionEliminar(lugar)
            }
            tableRow.addView(eliminarButton)

            // Agrega la fila a la tabla
            tableLayout.addView(tableRow)
        }
    }
}
