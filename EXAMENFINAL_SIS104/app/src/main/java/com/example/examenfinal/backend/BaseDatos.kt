package com.example.examenfinal.backend

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context): SQLiteOpenHelper(context, BaseDatos.NOMBRE_BASE_DATOS, null, BaseDatos.VERSION_BASE_DATOS){

    companion object{
        private val VERSION_BASE_DATOS = 1
        private val NOMBRE_BASE_DATOS = "db_final_sis104"
        private val NOMBRE_TABLA = "usuarios"
        private val ID = "id"
        private val Nombre = "nombre"
        private val Email = "email"
        private val Genero = "genero"
        private val Estado = "estado"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREAR_TABLA =
            "CREATE TABLE $NOMBRE_TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT,$Nombre String,$Email String,$Genero String,$Estado String);"
        db?.execSQL(CREAR_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val BORRAR_TABLA = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(BORRAR_TABLA)
        onCreate(db)
    }

    fun addResultado(d: usuario): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(ID, d.id)
            put(Nombre, d.nombre)
            put(Email, d.email)
            put(Genero, d.genero)
            put(Estado, d.estado)
        }
        val _success = db.insertWithOnConflict(NOMBRE_TABLA, null, values, SQLiteDatabase.CONFLICT_REPLACE)
        db.close()
        return (_success != -1L)
    }

    val d_result: List<usuario>
        @SuppressLint("Range")
        get() {
            val userList = ArrayList<usuario>()
            val db = this.readableDatabase
            val selectQuery = "SELECT * FROM $NOMBRE_TABLA"
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        val user = usuario().apply {
                            id = cursor.getInt(cursor.getColumnIndex(ID))
                            nombre = cursor.getString(cursor.getColumnIndex(Nombre))
                            email = cursor.getString(cursor.getColumnIndex(Email))
                            genero = cursor.getString(cursor.getColumnIndex(Genero))
                            estado = cursor.getString(cursor.getColumnIndex(Estado))
                        }
                        userList.add(user)
                    } while (cursor.moveToNext())
                }
                cursor.close()
            }
            return userList
        }

}