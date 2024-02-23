package com.example.simulacro2trimestre

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GestorDB (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Empresa.db"
        const val TABLE_NAME = "DatosPersonales"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "nombre"
        const val COLUMN_LASTNAME = "apellidos"
        const val COLUMN_ADDRESS = "direccion"
        const val COLUMN_CP = "cp"
        const val COLUMN_CITY = "ciudad"
        const val COLUMN_PROVINCIA = "provincia"
        const val COLUMN_TELEFONO = "telefono"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE =
            ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_LASTNAME TEXT ," +
                    "$COLUMN_ADDRESS TEXT , $COLUMN_CP TEXT , $COLUMN_CITY TEXT , $COLUMN_PROVINCIA TEXT, $COLUMN_TELEFONO INT)")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(datos: DatosPersonales) {
        val values = ContentValues()
        values.put(COLUMN_NAME, datos.nombre)
        values.put(COLUMN_LASTNAME, datos.apellidos)
        values.put(COLUMN_ADDRESS, datos.direccion)
        values.put(COLUMN_CP, datos.cp)
        values.put(COLUMN_CITY, datos.ciudad)
        values.put(COLUMN_PROVINCIA, datos.provincia)
        values.put(COLUMN_TELEFONO, datos.telefono)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun removeData() {
        val delete_data = "delete from $TABLE_NAME"
        val db = this.writableDatabase
        db.execSQL(delete_data)
    }

    fun getAllData(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}