package com.micky.miprimeraaplicacion.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class BaseDatos extends SQLiteOpenHelper {
    String SQL_CREATE="CREATE TABLE personas(id INTEGER PRIMARY KEY AUTOINCREMENT,paterno VARCHAR(40), materno VARCHAR(40), nombre VARCHAR(60));";
    String SQL_DROP="DROP TABLE IF EXISTS personas;";

    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);
    }

    // Método para agregar una persona a la base de datos
    public void agregarPersona(String paterno, String materno, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("paterno", paterno);
        values.put("materno", materno);
        values.put("nombre", nombre);
        db.insert("personas", null, values);
        db.close();
    }

    // Método para obtener todas las personas de la base de datos
    public List<String> obtenerTodasLasPersonas() {
        List<String> listaPersonas = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM personas", null);
        if (cursor.moveToFirst()) {
            do {
                String persona = "ID: " + cursor.getInt(0) +
                        ", Paterno: " + cursor.getString(1) +
                        ", Materno: " + cursor.getString(2) +
                        ", Nombre: " + cursor.getString(3);
                listaPersonas.add(persona);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaPersonas;
    }

    // Método para actualizar los datos de una persona en la base de datos
    public void actualizarPersona(int id, String paterno, String materno, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("paterno", paterno);
        values.put("materno", materno);
        values.put("nombre", nombre);
        db.update("personas", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Método para eliminar una persona de la base de datos
    public void eliminarPersona(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("personas", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}
