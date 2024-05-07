package com.micky.primerkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.micky.primerkotlin.backend.Grafico

class GraficoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Grafico(this))

        /*var buttonSalirGrafico = Button(this)
        buttonSalirGrafico = findViewById(R.id.buttonSalirGrafico)
        buttonSalirGrafico.setOnClickListener {
            finish()
        }*/
    }

}