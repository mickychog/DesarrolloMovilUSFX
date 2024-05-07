package com.micky.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.micky.miprimeraaplicacion.backend.BaseDatos;

import java.util.List;

public class MostrarActivity extends AppCompatActivity {
    private TableLayout tableLayoutPersonas;
    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        // Inicializar la base de datos
        baseDatos = new BaseDatos(this, "nombre_de_la_base_de_datos", null, 1);

        // Referencia a la tabla
        tableLayoutPersonas = findViewById(R.id.tableLayoutPersonas);

        // Obtener todas las personas de la base de datos
        List<String> listaPersonas = baseDatos.obtenerTodasLasPersonas();

        // Mostrar las personas en la tabla
        mostrarPersonasEnTabla(listaPersonas);
    }

    // Método para mostrar las personas en la tabla
    private void mostrarPersonasEnTabla(List<String> listaPersonas) {
        for (String persona : listaPersonas) {
            // Separar los datos de la persona (nombre, apellido paterno, apellido materno)
            String[] datosPersona = persona.split(",");

            // Crear una nueva fila para la persona
            TableRow row = new TableRow(this);

            // Agregar columnas para cada dato de la persona
            TextView textViewNombre = new TextView(this);
            textViewNombre.setText(datosPersona[1]);
            textViewNombre.setPadding(5, 5, 5, 5);
            row.addView(textViewNombre);

            TextView textViewPaterno = new TextView(this);
            textViewPaterno.setText(datosPersona[1]);
            textViewPaterno.setPadding(5, 5, 5, 5);
            row.addView(textViewPaterno);

            TextView textViewMaterno = new TextView(this);
            textViewMaterno.setText(datosPersona[2]);
            textViewMaterno.setPadding(5, 5, 5, 5);
            row.addView(textViewMaterno);

            // Agregar botón "Editar"
            Button buttonEditar = new Button(this);
            buttonEditar.setText("Editar");
            buttonEditar.setPadding(5, 5, 5, 5);
            buttonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para editar la persona
                    Toast.makeText(MostrarActivity.this, "Editar: " + datosPersona[0], Toast.LENGTH_SHORT).show();
                }
            });
            row.addView(buttonEditar);

            // Agregar botón "Eliminar"
            Button buttonEliminar = new Button(this);
            buttonEliminar.setText("Eliminar");
            buttonEliminar.setPadding(5, 5, 5, 5);
            buttonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para eliminar la persona
                    Toast.makeText(MostrarActivity.this, "Eliminar: " + datosPersona[0], Toast.LENGTH_SHORT).show();
                }
            });
            row.addView(buttonEliminar);

            // Agregar la fila a la tabla
            tableLayoutPersonas.addView(row);
        }
    }
}
