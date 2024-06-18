package com.example.examenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttRecuperar = findViewById<Button>(R.id.buttonRecuperar)
        val buttSalir = findViewById<Button>(R.id.buttonSalir)

        buttRecuperar.setOnClickListener {
            val intent = Intent(this@MainActivity, UsuariosActivity::class.java)
            startActivity(intent)
        }

        buttSalir.setOnClickListener {
            finish()
        }
    }
}