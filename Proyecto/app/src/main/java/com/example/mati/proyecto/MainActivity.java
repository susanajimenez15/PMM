package com.example.mati.proyecto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Cursor usuario;
    EditText nombre,contrasenya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar = (Button) findViewById(R.id.BEntrar);
        nombre = (EditText) findViewById(R.id.nombre);
        contrasenya = (EditText) findViewById(R.id.contrasenya);

        // Abrimos la BD en modo escritura
        DBHelper dbHelper = new DBHelper(this, "DBClientes", null, 1 );

        // Obtenemos referencia a la BD para poder modificarla
        SQLiteDatabase bd = dbHelper.getWritableDatabase();

        // Si abrimos de forma correcta la BD
        if (bd != null)
        {

            String nom = nombre.getText().toString();
            String contra = contrasenya.getText().toString();

            usuario = bd.rawQuery("select nombre, password from Clientes where nombre='"+nom+"', and password='"+contra+"'", null);

            // Comprobamos en la BD, si el usuario y la contraseña son correctos, que pueda entrar
            if (usuario.moveToFirst()==true)
            {


            }

            int codigo = 1;
            String nombre = "admin";
            String password = "admin";
            bd.execSQL("insert into Clientes (codigo, nombre, password)"+"values ("+codigo+",'"+nombre+"','"+password+"')");


            // Introducimos 3 clientes de ejemplo
            /*for (int i = 1; i <= 3; i++) {
                // Creamos los datos
                int codigo = i;
                String nombre = "Cliente "+ i;
                String password = i + "000";

                // Introducimos los datos en la tabla Clientes
                bd.execSQL("insert into Clientes (codigo, nombre, telefono)"+"values ("+codigo+",'"+nombre+"','"+password+"')");
            }
            */

           /* // Introducimos 3 tratamientos de ejemplo
            for (int i = 1; i<= 3; i++){
                // Creamos los datos
                int codigo = i;
                String nombre = "Tratamiento "+i;
                double precio = i*5;

                // Introducimos los datos en la tabla Tratamientos
                bd.execSQL("insert into Tratamientos(codigo, nombre, precio)"+"values ("+codigo+",'"+nombre+"','"+precio+"')");

            }*/

            bd.close();
        }
    }
}
