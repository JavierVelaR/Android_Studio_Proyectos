package com.example.datospersonales

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class GestorBD (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "biblioteca.db"
        const val TABLE_NAME = "libros"
        const val COLUMN_ID = "_id"
        const val COLUMN_TITTLE = "titulo"
        const val COLUMN_AUTOR = "autor"
        const val COLUMN_GENRE = "genero"
        const val COLUMN_EDITORIAL = "editorial"
        const val COLUMN_YEAR = "anio"

    }

    override fun onCreate(db: SQLiteDatabase) {
        //val delete = ("drop table $TABLE_NAME")
        val CREATE_TABLE =
            ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITTLE TEXT, $COLUMN_AUTOR TEXT," +
                    "$COLUMN_GENRE TEXT, $COLUMN_EDITORIAL TEXT, $COLUMN_YEAR INT)")
        Log.d("Crear tabla", CREATE_TABLE)
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addLibro(libro: Libro) {
        val values = ContentValues()
        Log.d("Values", "Se crea ContentValues.")

        values.put(COLUMN_TITTLE, libro.titulo)
        values.put(COLUMN_AUTOR, libro.autor)
        values.put(COLUMN_GENRE, libro.genero)
        values.put(COLUMN_EDITORIAL, libro.editorial)
        values.put(COLUMN_YEAR, libro.anio)
        val db = this.writableDatabase
        Log.d("Values", "Se insertan los datos.")

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllLibros(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}