package com.example.mati.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        DBHelper dbHelper = new DBHelper(this, "DBUser", null, 1 );

        // Obtenemos referencia a la BD para poder modificarla
        SQLiteDatabase bd = dbHelper.getWritableDatabase();

        // Si abrimos de forma correcta la BD
        if (bd != null)
        {

            //String nom = nombre.getText().toString();
            //String contra = contrasenya.getText().toString();

            String nom="admin";
            String contra="admin";

            //usuario = bd.rawQuery("select nombre,password from Clientes where nombre='"+nom+"' and password='"+contra+"'", null);
            usuario = bd.query("Clientes",new String[]{"nombre","password"},null,null,null,null,null);
            // Comprobamos en la BD, si el usuario y la contraseña son correctos, que pueda entrar
            if (usuario.moveToFirst()==true)
            {
                // Cojemos los datos
                String name=usuario.getString(0);
                String pssw = usuario.getString(1);

                if(nom.equals(name)&& contra.equals(pssw)){

                    //Si son iguales nos vamos a otra ventana de la activity

                    Intent ventana = new Intent(MainActivity.this, Inicio.class);
                    ventana.putExtra("nombre",nombre.getText().toString());
                    ventana.putExtra("contrasenya",contrasenya.getText().toString());

                    startActivity(ventana);
                    Toast toastEntrar = Toast.makeText(getApplicationContext(),"Entrando..",Toast.LENGTH_SHORT);

                }


            }else{
                Toast toastError = Toast.makeText(getApplicationContext(),"Error...",Toast.LENGTH_SHORT);
            }

            int codigo = 1;
            String nombre = "admin";
            String password = "admin";
            bd.execSQL("insert into Clientes(codigo, nombre, password)"+"values ("+codigo+",'"+nombre+"','"+password+"')");


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
