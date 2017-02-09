package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by sujic on 08/02/2017.
 */
public class Registro extends AppCompatActivity {

    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText contrasenya = (EditText) findViewById(R.id.contrasenya);

        Button registrar = (Button) findViewById(R.id.BRegistrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                String name = nombre.getText().toString();
                String password = contrasenya.getText().toString();
                Integer codigo =  random.nextInt(500)+1;
                // Abrimos la BD en modo escritura
                DBHelper dbDatos = new DBHelper(Registro.this, "BaseDatos", null, 1 );

                // Obtenemos referencia a la BD para poder modificarla
                SQLiteDatabase bd = dbDatos.getWritableDatabase();

                String sqlInsert = "INSERT INTO Clientes (codigo, nombre, contrasenya) values('"+codigo+"','"+name+"','"+contrasenya+"')";
                bd.execSQL(sqlInsert);
                bd.close();
                Toast toast = Toast.makeText(getApplicationContext(), "Creando Usuario...", Toast.LENGTH_SHORT);
                toast.show();
                Intent ventana = new Intent(Registro.this, Login.class);
                startActivity(ventana);
            }
        });
    }
}