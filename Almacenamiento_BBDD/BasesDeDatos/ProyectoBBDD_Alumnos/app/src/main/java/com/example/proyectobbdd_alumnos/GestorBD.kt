package com.example.proyectobbdd_alumnos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class GestorBD (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

    companion object{
        private const val DATABASE_VERSION=1
        private const val DATABASE_NAME="BaseDatosAlumnos.db"
        const val TABLE_NAME="alumnos"
        const val COLUMN_ID="_id"
        const val COLUMN_NAME="nombre"
        const val COLUMN_LASTNAME="apellidos"
        const val COLUMN_DNI="dni"
        const val COLUMN_AGE="edad"
        const val COLUMN_COURSE="curso"

    }

    override fun onCreate(db:SQLiteDatabase){
        //val delete = ("drop table $TABLE_NAME")
        val CREATE_TABLE=
            ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_LASTNAME TEXT," +
                    "$COLUMN_DNI TEXT, $COLUMN_AGE INT, $COLUMN_COURSE INT)")
        Log.d("Crear tabla", CREATE_TABLE)
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db:SQLiteDatabase,oldVersion:Int,newVersion:Int){
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addAlumno(alumno:Alumno){
        val values = ContentValues()
        Log.d("Values","Se crea ContentValues.")

        values.put(COLUMN_NAME,alumno.nombre)
        values.put(COLUMN_LASTNAME,alumno.apellidos)
        values.put(COLUMN_DNI,alumno.dni)
        values.put(COLUMN_AGE,alumno.edad)
        values.put(COLUMN_COURSE,alumno.curso)
        val db=this.writableDatabase
        Log.d("Values","Se insertan los datos.")

        db.insert(TABLE_NAME,null,values)
        db.close()
    }

    fun getAllAlumnos(): Cursor?{
        val db=this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME",null)
    }
}