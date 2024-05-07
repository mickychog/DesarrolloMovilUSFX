package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.micky.miprimeraaplicacion.backend.BaseDatos;

public class CrearActivity extends AppCompatActivity {
    private EditText editTextPaterno;
    private EditText editTextMaterno;
    private EditText editTextNombre;
    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        // Inicializar la base de datos
        baseDatos = new BaseDatos(this, "nombre_de_la_base_de_datos", null, 1);


        // Referencias a los elementos de la interfaz
        editTextPaterno = findViewById(R.id.editTextPaterno);
        editTextMaterno = findViewById(R.id.editTextMaterno);
        editTextNombre = findViewById(R.id.editTextNombre);
        Button buttonCrear = findViewById(R.id.buttonCrear);
        Button buttonMostrar = findViewById(R.id.buttonMostrar);
        Button buttonVolver = findViewById(R.id.buttonVolver);

        // Configurar el botón para agregar una persona
        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarPersona();
            }
        });

        // Configurar el botón para mostrar todas las personas
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para mostrar todas las personas
                // Esto puede incluir abrir una nueva actividad o mostrar un diálogo con la lista de personas.
                Toast.makeText(CrearActivity.this, "Mostrar todas las personas", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el botón para volver atrás
        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finalizar la actividad y volver atrás
            }
        });
    }

    // Método para agregar una persona a la base de datos
    private void agregarPersona() {
        String paterno = editTextPaterno.getText().toString().trim();
        String materno = editTextMaterno.getText().toString().trim();
        String nombre = editTextNombre.getText().toString().trim();

        if (!paterno.isEmpty() && !nombre.isEmpty()) {
            baseDatos.agregarPersona(paterno, materno, nombre);
            Toast.makeText(this, "Persona agregada correctamente", Toast.LENGTH_SHORT).show();
            // Limpiar los campos después de agregar la persona
            editTextPaterno.getText().clear();
            editTextMaterno.getText().clear();
            editTextNombre.getText().clear();
        } else {
            Toast.makeText(this, "Por favor ingresa al menos el paterno y nombre", Toast.LENGTH_SHORT).show();
        }
    }
}
