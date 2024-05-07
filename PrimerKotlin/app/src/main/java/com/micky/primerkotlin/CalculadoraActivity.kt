package com.micky.primerkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.micky.primerkotlin.backend.Operaciones

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonS: Button
    private lateinit var buttonR: Button
    private lateinit var buttonM: Button
    private lateinit var buttonD: Button
    private lateinit var buttonC: Button
    private lateinit var buttonSalirCalculadora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        editTextA = findViewById(R.id.editTextA)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button0 = findViewById(R.id.button0)
        buttonS = findViewById(R.id.buttonS)
        buttonR = findViewById(R.id.buttonR)
        buttonM = findViewById(R.id.buttonM)
        buttonD = findViewById(R.id.buttonD)
        buttonC = findViewById(R.id.buttonC)
        buttonSalirCalculadora = findViewById(R.id.buttonSalirCalculadora)

        val buttonIgual: Button = findViewById(R.id.buttonIgual)

        button1.setOnClickListener {
            val valorActual = editTextA.text.toString() + "1"
            editTextA.setText(valorActual)
        }

        button2.setOnClickListener {
            val valorActual = editTextA.text.toString() + "2"
            editTextA.setText(valorActual)
        }

        button3.setOnClickListener {
            val valorActual = editTextA.text.toString() + "3"
            editTextA.setText(valorActual)
        }

        button4.setOnClickListener {
            val valorActual = editTextA.text.toString() + "4"
            editTextA.setText(valorActual)
        }

        button5.setOnClickListener {
            val valorActual = editTextA.text.toString() + "5"
            editTextA.setText(valorActual)
        }

        button6.setOnClickListener {
            val valorActual = editTextA.text.toString() + "6"
            editTextA.setText(valorActual)
        }

        button7.setOnClickListener {
            val valorActual = editTextA.text.toString() + "7"
            editTextA.setText(valorActual)
        }

        button8.setOnClickListener {
            val valorActual = editTextA.text.toString() + "8"
            editTextA.setText(valorActual)
        }

        button9.setOnClickListener {
            val valorActual = editTextA.text.toString() + "9"
            editTextA.setText(valorActual)
        }

        button0.setOnClickListener {
            val valorActual = editTextA.text.toString() + "0"
            editTextA.setText(valorActual)
        }

        buttonS.setOnClickListener {
            val valorActual = editTextA.text.toString() + "+"
            editTextA.setText(valorActual)
        }

        buttonR.setOnClickListener {
            val valorActual = editTextA.text.toString() + "-"
            editTextA.setText(valorActual)
        }

        buttonM.setOnClickListener {
            val valorActual = editTextA.text.toString() + "*"
            editTextA.setText(valorActual)
        }

        buttonD.setOnClickListener {
            val valorActual = editTextA.text.toString() + "/"
            editTextA.setText(valorActual)
        }

        buttonC.setOnClickListener {
            editTextA.setText("")
        }

        val operaciones = Operaciones(0, 0)

        buttonIgual.setOnClickListener {
            try {
                val expresion = editTextA.text.toString()

                val partes = expresion.split("[+\\-*/]".toRegex())
                val numero1 = partes[0].toInt()
                val numero2 = partes[1].toInt()

                val operador = expresion.replace("[0-9]".toRegex(), "")

                operaciones.setA(numero1)
                operaciones.setB(numero2)

                val resultado = operaciones.realizarOperacion(operador)
                editTextA.setText(resultado.toString())
            } catch (e: Exception) {
                editTextA.setText("Error")
            }
        }

        buttonSalirCalculadora.setOnClickListener {
            finish()
        }
    }
}
