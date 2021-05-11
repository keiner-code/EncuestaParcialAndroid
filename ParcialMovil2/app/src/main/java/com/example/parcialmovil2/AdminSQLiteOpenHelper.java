package com.example.parcialmovil2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table encuesta(id int primary key, respuesta1 text, respuesta2 text, respuesta3 text, respuesta4 text, respuesta5 text)");
         db.execSQL("create table datosusuario(id int primary key, nombre text, apellido text, telefono text, direccion text, estadocivil text, profesion text, estrato text, cargo text, nivelestudio text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
