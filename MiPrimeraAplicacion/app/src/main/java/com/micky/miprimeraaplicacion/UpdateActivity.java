package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.micky.miprimeraaplicacion.backend.BaseDatos;

public class UpdateActivity extends AppCompatActivity {
    private EditText editTextPaterno;
    private EditText editTextMaterno;
    private EditText editTextNombre;
    private Button buttonActualizar;
    private int personaId;
    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // Inicializar la base de datos
        baseDatos = new BaseDatos(this, "nombre_de_la_base_de_datos", null, 1);

        // Obtener los datos de la persona a editar del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            personaId = extras.getInt("personaId");
            String paterno = extras.getString("paterno");
            String materno = extras.getString("materno");
            String nombre = extras.getString("nombre");

            // Referencias a los elementos de la interfaz
            editTextPaterno = findViewById(R.id.editTextPaterno);
            editTextMaterno = findViewById(R.id.editTextMaterno);
            editTextNombre = findViewById(R.id.editTextNombre);
            buttonActualizar = findViewById(R.id.buttonActualizar);

            // Mostrar los datos de la persona en los EditText
            editTextPaterno.setText(paterno);
            editTextMaterno.setText(materno);
            editTextNombre.setText(nombre);
        }

        // Configurar el botón para actualizar los datos de la persona
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarPersona();
            }
        });
    }

    // Método para actualizar los datos de la persona en la base de datos
    private void actualizarPersona() {
        String paterno = editTextPaterno.getText().toString().trim();
        String materno = editTextMaterno.getText().toString().trim();
        String nombre = editTextNombre.getText().toString().trim();

        if (!paterno.isEmpty() && !nombre.isEmpty()) {
            baseDatos.actualizarPersona(personaId, paterno, materno, nombre);
            Toast.makeText(this, "Persona actualizada correctamente", Toast.LENGTH_SHORT).show();
            finish(); // Cerrar la actividad y volver atrás
        } else {
            Toast.makeText(this, "Por favor ingresa al menos el paterno y nombre", Toast.LENGTH_SHORT).show();
        }
    }
}
