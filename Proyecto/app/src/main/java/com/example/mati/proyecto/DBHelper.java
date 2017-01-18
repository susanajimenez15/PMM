package com.example.mati.proyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mati on 18/01/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Sentencia SQL para crear tabla Clientes
    String clientesSQL = "create table Clientes (codigo INTEGER primary key autoincrement, nombre TEXT, password TEXT)";
    String clientesSQLinsert = "insert into Clientes values(1, 'admin', 'admin')";
    // Sentencia SQL para crear la tabla Tratamientos
    //String tratamientoSQL = "create tabla Tratamientos (codigo INTEGER, nombre TEXT, precio DOUBLE)";

    public DBHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    // Se ejecutara automaticamente cuando se necesite crear la BD.
    // Es decir, se ejecutara cuando la BD no exista
    // Aqui deberemos crear todas las tablas necesarias e insertar los datos iniciales si es necesario
    @Override
    public void onCreate(SQLiteDatabase bd){
        // Ejecutamos la sentencia para crear la tabla Clientes
        bd.execSQL(clientesSQL);
        bd.execSQL(clientesSQLinsert);
       // bd.execSQL(tratamientoSQL);
    }

    // Se lanza automaticamente cuado sea necesario una actualizacion de la BD o una conversion de datos
    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {

        // Eliminamos version anterior de la tabla
        bd.execSQL("drop table if exists Clientes");

        // Creamos nueva version de la tabla
        bd.execSQL(clientesSQL);
    }
}
