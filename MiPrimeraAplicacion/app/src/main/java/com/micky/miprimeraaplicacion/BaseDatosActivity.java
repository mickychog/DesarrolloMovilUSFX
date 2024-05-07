package com.micky.miprimeraaplicacion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.micky.miprimeraaplicacion.backend.BaseDatos;

public class BaseDatosActivity extends AppCompatActivity {
    Button buttonCrear, buttonMostrar, buttonUpdate,buttonDelete, buttonSalir;
    BaseDatos baseDatos;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        buttonCrear=findViewById(R.id.buttonCrear);
        buttonMostrar=findViewById(R.id.buttonMostrar);
        buttonUpdate=findViewById(R.id.buttonUpdate);
        buttonDelete=findViewById(R.id.buttonDelete);
        buttonSalir=findViewById(R.id.buttonSalir);

        baseDatos=new BaseDatos(BaseDatosActivity.this,"BDAcad",null,1);

        db = baseDatos.getWritableDatabase();

        String SQL="INSERT INTO PERSONAS(paterno,materno,nombre)VALUES('Perez','Lozano','Juan');";
        db.execSQL(SQL);

        SQL="SELECT * FROM PERSONAS;";
        db = baseDatos.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQL,null);
        if (cursor.moveToFirst()){
            do{
                String nombre = cursor.getString(3);
                Toast.makeText(BaseDatosActivity.this,"Nombre: "+nombre, Toast.LENGTH_SHORT).show();
            }while(cursor.moveToNext());
        }else{
            Toast.makeText(BaseDatosActivity.this,"No existe registros", Toast.LENGTH_SHORT).show();

        }

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BaseDatosActivity.this, CrearActivity.class);
                startActivity(intent);
            }
        });
        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BaseDatosActivity.this, MostrarActivity.class);
                startActivity(intent);
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}