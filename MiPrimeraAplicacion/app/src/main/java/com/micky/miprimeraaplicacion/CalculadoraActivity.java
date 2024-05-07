package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.micky.miprimeraaplicacion.backend.Operaciones;

public class CalculadoraActivity extends AppCompatActivity {

    EditText editTextA, editTextB,editTextC;
    Button buttonOperaciones, buttonResta,buttonMultiplicacion,buttonDivision,button1,button2,button3,
            button4,button5,button6,button7,button8,button9,button0,buttonS,buttonR,buttonM,buttonD,buttonC,buttonSalirCalculadora;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        buttonOperaciones = findViewById(R.id.buttonOperaciones);
        buttonResta = findViewById(R.id.buttonResta);
        buttonMultiplicacion = findViewById(R.id.buttonMultiplicacion);
        buttonDivision = findViewById(R.id.buttonDivision);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button0=findViewById(R.id.button0);
        buttonS=findViewById(R.id.buttonS);
        buttonR=findViewById(R.id.buttonR);
        buttonM=findViewById(R.id.buttonM);
        buttonD=findViewById(R.id.buttonD);
        buttonC=findViewById(R.id.buttonC);
        buttonSalirCalculadora=findViewById(R.id.buttonSalirCalculadora);

        Button buttonIgual = findViewById(R.id.buttonIgual);

        buttonOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this, "La suma es :"+operaciones.suma(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this, "La resta es :"+operaciones.resta(), Toast.LENGTH_SHORT).show();
            }
        });
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this, "La multiplicacion es :"+operaciones.multiplicacion(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                int x = Integer.parseInt(editTextA.getText().toString());
                int y = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(x, y);
                Toast.makeText(CalculadoraActivity.this, "La Division es :"+operaciones.division(), Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "1";
                editTextC.setText(valorActual);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "2";
                editTextC.setText(valorActual);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "3";
                editTextC.setText(valorActual);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "4";
                editTextC.setText(valorActual);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "5";
                editTextC.setText(valorActual);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "6";
                editTextC.setText(valorActual);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "7";
                editTextC.setText(valorActual);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "8";
                editTextC.setText(valorActual);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "9";
                editTextC.setText(valorActual);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "0";
                editTextC.setText(valorActual);
            }
        });
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "+";
                editTextC.setText(valorActual);
            }
        });
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "-";
                editTextC.setText(valorActual);
            }
        });
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "*";
                editTextC.setText(valorActual);
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = valorActual + "/";
                editTextC.setText(valorActual);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String valorActual = editTextC.getText().toString();
                valorActual = "";
                editTextC.setText(valorActual);
            }
        });

        Operaciones operaciones = new Operaciones(0, 0);

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtén el contenido del EditText
                    String expresion = editTextC.getText().toString();

                    // Divide la expresión en números y operador
                    String[] partes = expresion.split("[+\\-*/]");
                    int numero1 = Integer.parseInt(partes[0]);
                    int numero2 = Integer.parseInt(partes[1]);

                    // Obtiene el operador
                    String operador = expresion.replaceAll("[0-9]", "");

                    // Establece los valores en la instancia de Operaciones
                    operaciones.setA(numero1);
                    operaciones.setB(numero2);

                    // Realiza la operación y muestra el resultado en el EditText
                    int resultado = operaciones.realizarOperacion(operador);
                    editTextC.setText(String.valueOf(resultado));
                } catch (Exception e) {
                    // Maneja posibles errores en la expresión matemática
                    editTextC.setText("Error");
                }
            }
        });
        buttonSalirCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}