package com.micky.primerkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonSalir = Button(this)
        var buttonCrud = Button(this)
        var buttonCalculadora = Button(this)
        var buttonGrafico = Button(this)
        var buttonCaratula = Button(this)
        var buttonBaseDatos = Button(this)

        buttonCalculadora = findViewById(R.id.buttonCalculadora)
        buttonCrud = findViewById(R.id.buttonCrud)
        buttonGrafico = findViewById(R.id.buttonGrafico)
        buttonSalir = findViewById(R.id.buttonSalir)
        buttonCaratula = findViewById(R.id.buttonCaratula)
        buttonBaseDatos = findViewById(R.id.buttonBaseDatos)

        buttonCalculadora.setOnClickListener {
            val intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            startActivity(intent)
        }
        buttonCrud.setOnClickListener {
            val intent = Intent(this@MainActivity, CrudActivity::class.java)
            startActivity(intent)
        }
        buttonGrafico.setOnClickListener {
            val intent = Intent(this@MainActivity, GraficoActivity::class.java)
            startActivity(intent)
        }
        buttonCaratula.setOnClickListener {
            val intent = Intent(this@MainActivity, CaratulaActivity::class.java)
            startActivity(intent)
        }
        buttonBaseDatos.setOnClickListener {
            val intent = Intent(this@MainActivity, BaseDatosActivity::class.java)
            startActivity(intent)
        }
        buttonSalir.setOnClickListener {
            finish()
        }
    }
}