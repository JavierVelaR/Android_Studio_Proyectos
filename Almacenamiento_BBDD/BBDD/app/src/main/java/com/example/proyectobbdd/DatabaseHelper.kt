package com.example.proyectobbdd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "miBaseDatos.db"
        const val TABLE_NAME = "nombres"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "nombre"
        const val COLUMN_PASS = "pass"
    }
    //creamos el metodo oncreate que crea la tabla
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, $COLUMN_PASS TEXT)"
        db.execSQL(CREATE_TABLE)
    }
    //creamos el metodo que permite eliminar la table y Volver a crearla
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}