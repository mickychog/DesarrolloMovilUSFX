package com.micky.primerkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CrudActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        var buttonSalirCrud = Button(this)
        buttonSalirCrud = findViewById(R.id.buttonSalirCrud)

        buttonSalirCrud.setOnClickListener {
            finish()
        }
    }
}