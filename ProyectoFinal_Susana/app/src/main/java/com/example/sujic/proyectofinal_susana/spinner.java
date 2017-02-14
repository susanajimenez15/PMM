<<<<<<< HEAD
package com.example.sujic.proyectofinal_susana;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujic on 08/02/2017.
 */
public class spinner extends AppCompatActivity{

    private Usuarios[] datos;
    public ArrayList<Usuarios> Usuarios = new ArrayList<Usuarios>();

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Abrimos la BD en modo escritura
        DBHelper usuarioBD = new DBHelper(this, "BaseDatos", null, 1);
        SQLiteDatabase bd = usuarioBD.getWritableDatabase();

        String [] info = new String[] {"codigo","nombre","contrasenya"};

        Cursor cursor = bd.query("Clientes", info, null, null,null,null,null);
        datos = new Usuarios[cursor.getCount()];

        int i=0;

        if(cursor.moveToFirst()==true){

            do {
                String codigo = cursor.getString(0);
                String nombre = cursor.getString(1);
                String contrasenya = cursor.getString(2);

                datos[i] = new Usuarios(codigo, nombre, contrasenya);

                i++;
            }while (cursor.moveToNext());
        }

        AdaptadorUsuarios adaptador = new AdaptadorUsuarios(this);
        android.widget.Spinner usuarios = (android.widget.Spinner) findViewById(R.id.spinner2);
        usuarios.setAdapter(adaptador);


        // Cerramos la BD
        bd.close();
    }

    public class AdaptadorUsuarios extends ArrayAdapter {

        Activity context;

        AdaptadorUsuarios(Activity context) {

            super(context, R.layout.activity_usuarios, datos);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDropDown = getView(position, convertView, parent);
            return vistaDropDown;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_usuarios, null);

            TextView cod = (TextView) item.findViewById(R.id.cod);
            cod.setText(datos[i].getCodigo());

            TextView us = (TextView) item.findViewById(R.id.user);
            us.setText(datos[i].getNombre());

            TextView pw = (TextView) item.findViewById(R.id.pwd);
            pw.setText(datos[i].getContrasenya());

            return (item);
        }

    }
}
=======
package com.example.sujic.proyectofinal_susana;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sujic on 08/02/2017.
 */
public class spinner extends AppCompatActivity{

    private Usuarios[] datos;
    public ArrayList<Usuarios> Usuarios = new ArrayList<Usuarios>();

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Abrimos la BD en modo escritura
        DBHelper usuarioBD = new DBHelper(this, "BaseDatos", null, 1);
        SQLiteDatabase bd = usuarioBD.getWritableDatabase();

        String [] info = new String[] {"codigo","nombre","contrasenya"};

        Cursor cursor = bd.query("Clientes", info, null, null,null,null,null);
        datos = new Usuarios[cursor.getCount()];

        int i=0;

        if(cursor.moveToFirst()==true){

            do {
                String codigo = cursor.getString(0);
                String nombre = cursor.getString(1);
                String contrasenya = cursor.getString(2);

                datos[i] = new Usuarios(codigo, nombre, contrasenya);

                i++;
            }while (cursor.moveToNext());
        }

        AdaptadorUsuarios adaptador = new AdaptadorUsuarios(this);
        android.widget.Spinner usuarios = (android.widget.Spinner) findViewById(R.id.spinner2);
        usuarios.setAdapter(adaptador);


        // Cerramos la BD
        bd.close();
    }

    public class AdaptadorUsuarios extends ArrayAdapter {

        Activity context;

        AdaptadorUsuarios(Activity context) {

            super(context, R.layout.activity_usuarios, datos);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDropDown = getView(position, convertView, parent);
            return vistaDropDown;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_usuarios, null);

            TextView cod = (TextView) item.findViewById(R.id.cod);
            cod.setText(datos[i].getCodigo());

            TextView us = (TextView) item.findViewById(R.id.user);
            us.setText(datos[i].getNombre());

            TextView pw = (TextView) item.findViewById(R.id.pwd);
            pw.setText(datos[i].getContrasenya());

            return (item);
        }

    }
}
>>>>>>> 598d62b3064f0a063d00e637e91364996848f658
