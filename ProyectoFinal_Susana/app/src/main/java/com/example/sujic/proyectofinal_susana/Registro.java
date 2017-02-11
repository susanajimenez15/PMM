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
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by sujic on 08/02/2017.
 */
public class Registro extends AppCompatActivity {

    private Cursor cursor;
    String BD_NAME = "BaseDatos1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText contrasenya = (EditText) findViewById(R.id.contrasenya);

        Button registrar = (Button) findViewById(R.id.BRegistrar);
        ImageButton volver = (ImageButton) findViewById(R.id.Bvolver);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                String name = nombre.getText().toString();
                String password = contrasenya.getText().toString();
                Integer codigo =  random.nextInt(500)+1;

                // Comprobamos que no haya ningún campo vacio
                do{
                    if(name.isEmpty()){
                        Toast avisoName = Toast.makeText(getApplicationContext(),"!AVISO¡ El nombre esta vacio",Toast.LENGTH_SHORT);
                        avisoName.show();
                    }

                    if(password.isEmpty()){
                        Toast avisoPass = Toast.makeText(getApplicationContext(),"!AVISO¡ La contraseña esta vacia",Toast.LENGTH_SHORT);
                        avisoPass.show();
                    }


                }while(name.isEmpty() || password.isEmpty());

                Toast toast = Toast.makeText(getApplicationContext(), "Creando Usuario...", Toast.LENGTH_SHORT);
                toast.show();

                // Abrimos la BD en modo escritura
                DBHelper dbDatos;
                dbDatos = new DBHelper(Registro.this, BD_NAME, null, 1 );

                // Obtenemos referencia a la BD para poder modificarla
                SQLiteDatabase bd = dbDatos.getWritableDatabase();


                String sqlInsert = "INSERT INTO Clientes values('"+codigo+"','"+name+"','"+password+"')";
                bd.execSQL(sqlInsert);
                bd.close();

                Intent ventana = new Intent(Registro.this, Login.class);
                startActivity(ventana);
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(Registro.this, Login.class);
                startActivity(ventana);

            }

        });
    }
}