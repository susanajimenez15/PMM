<<<<<<< HEAD
package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Cursor cursor;
    EditText nombre,contrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button entrar = (Button) findViewById(R.id.BEntrar);
        Button salir = (Button) findViewById(R.id.BSalir);
        Button registrar = (Button) findViewById(R.id.BRegistro);

        nombre = (EditText) findViewById(R.id.nombre);
        contrasenya = (EditText) findViewById(R.id.contrasenya);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nombre.getText().toString();
                String password = contrasenya.getText().toString();


                // Abrimos la BD en modo escritura
                DBHelper dbDatos = new DBHelper(Login.this, "BaseDatos", null, 1 );

                // Obtenemos referencia a la BD para poder modificarla
                SQLiteDatabase bd = dbDatos.getWritableDatabase();

                cursor = bd.rawQuery("SELECT nombre,contrasenya from Clientes where nombre='"+name+"' and  contrasenya='"+password+"'", null);

                // Preguntamos si hay algun dato en el cursor:
                if(cursor.moveToFirst() == true){

                    String usuario = cursor.getString(0);
                    String contra = cursor.getString(1);

                    if(name.equals(usuario)&&password.equals(contra)){

                        Intent ventana = new Intent(Login.this, Inicio.class);

                        ventana.putExtra("name", nombre.getText().toString());
                        ventana.putExtra("password", contrasenya.getText().toString());

                        startActivity(ventana);
                        Toast entrando = Toast.makeText(getApplicationContext(), "Entrando a tu cuenta...", Toast.LENGTH_SHORT);
                        entrando.show();


                    }else{
                        Toast error = Toast.makeText(getApplicationContext(), "Error al entrar en tu cuenta", Toast.LENGTH_SHORT);
                        error.show();

                    }

                }

            }

        });

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent ventanaRegistro = new Intent(Login.this, Registro.class);
                startActivity(ventanaRegistro);
                Toast registrando = Toast.makeText(getApplicationContext(), "Entrando a registro..", Toast.LENGTH_SHORT);
                registrando.show();

            }
        });

        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                finish();

            }


        });




        // Si abrimos de forma correcta la BD
       // if (bd != null) {

            // Introducimos el usuario admin:admin para usarlo como prueba
            //String nombre = "admin";
            //String contra = "admin";
            //int codigo = 1;

            // Introducimos los datos en la tabla Clientes
        //    bd.execSQL("INSERT INTO Clientes (nombre, contrasenya) VALUES ('admin','admin')");
            //String nom = nombre.getText().toString();
            //String contra = contrasenya.getText().toString();
            //String nom = "admin";
            //String contra = "admin";

            //usuario = bd.rawQuery("select nombre,password from Clientes where nombre='" + nom + "', and password='" + contra + "'", null);

            // Comprobamos en la BD, si el usuario y la contraseña son correctos, que pueda entrar
           //if (usuario.moveToFirst() == true) {

             //  Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_LONG);

          // }

            //int codigo = 1;
           // String nombre = "admin";
            //String password = "admin";
           // bd.execSQL("insert into Clientes (codigo, nombre, password)" + "values (" + codigo + ",'" + nombre + "','" + password + "')");


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
         /*  Button entrar = (Button)findViewById(R.id.BEntrar);
            entrar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    // Abrimos BD en modo escritura
                    final SQLiteDatabase bd = dbDatos.getReadableDatabase();
                    EditText usuario = (EditText)findViewById(R.id.nombre);
                    EditText contrasenya = (EditText)findViewById(R.id.contrasenya);

                }
            });
         */

          //  bd.close();
        //}
    }
}
=======
package com.example.sujic.proyectofinal_susana;

import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Cursor cursor;
    EditText nombre, contrasenya;
    String BD_NAME = "BaseDatos1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button entrar = (Button) findViewById(R.id.BEntrar);
        Button salir = (Button) findViewById(R.id.BSalir);
        Button registrar = (Button) findViewById(R.id.BRegistro);

        nombre = (EditText) findViewById(R.id.nombre);
        contrasenya = (EditText) findViewById(R.id.contrasenya);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nombre.getText().toString();
                String password = contrasenya.getText().toString();


                // Abrimos la BD en modo escritura
                DBHelper dbDatos;
                dbDatos = new DBHelper(Login.this, BD_NAME, null, 1);

                // Obtenemos referencia a la BD para poder modificarla
                SQLiteDatabase bd = dbDatos.getWritableDatabase();

                if (name.isEmpty()) {
                    Toast aviso = Toast.makeText(getApplicationContext(), "Tienes que poner un nombre", Toast.LENGTH_SHORT);
                    aviso.show();
                }
                if (password.isEmpty()) {
                    Toast aviso = Toast.makeText(getApplicationContext(), "Tienes que poner una contraseña", Toast.LENGTH_SHORT);
                    aviso.show();
                }
                cursor = bd.rawQuery("SELECT nombre,contrasenya from Clientes where nombre='" + name + "' and  contrasenya='" + password + "'", null);

                // Preguntamos si hay algun dato en el cursor:
                if (cursor.moveToFirst() == true) {

                    String usuario = cursor.getString(0);
                    String contra = cursor.getString(1);

                    if (name.equals(usuario) && password.equals(contra)) {

                        Intent ventana = new Intent(Login.this, Inicio.class);

                        ventana.putExtra("name", nombre.getText().toString());
                        ventana.putExtra("password", contrasenya.getText().toString());

                        startActivity(ventana);
                        Toast entrando = Toast.makeText(getApplicationContext(), "Entrando a tu cuenta...", Toast.LENGTH_SHORT);
                        entrando.show();


                    }

                } else {
                    Toast error = Toast.makeText(getApplicationContext(), "Error en el usuario o contraseña", Toast.LENGTH_SHORT);
                    error.show();

                }

            }

        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ventanaRegistro = new Intent(Login.this, Registro.class);
                startActivity(ventanaRegistro);
                Toast registrando = Toast.makeText(getApplicationContext(), "Entrando a registro..", Toast.LENGTH_SHORT);
                registrando.show();

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }


        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_login, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.quees:
                Intent ventanaLocal = new Intent(Login.this, localizacion.class);
                startActivity(ventanaLocal);
                return true;

            default:
                return true;
        }
    }



    // Si abrimos de forma correcta la BD
    // if (bd != null) {

    // Introducimos el usuario admin:admin para usarlo como prueba
    //String nombre = "admin";
    //String contra = "admin";
    //int codigo = 1;

    // Introducimos los datos en la tabla Clientes
    //    bd.execSQL("INSERT INTO Clientes (nombre, contrasenya) VALUES ('admin','admin')");
    //String nom = nombre.getText().toString();
    //String contra = contrasenya.getText().toString();
    //String nom = "admin";
    //String contra = "admin";

    //usuario = bd.rawQuery("select nombre,password from Clientes where nombre='" + nom + "', and password='" + contra + "'", null);

    // Comprobamos en la BD, si el usuario y la contraseña son correctos, que pueda entrar
    //if (usuario.moveToFirst() == true) {

    //  Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_LONG);

    // }

    //int codigo = 1;
    // String nombre = "admin";
    //String password = "admin";
    // bd.execSQL("insert into Clientes (codigo, nombre, password)" + "values (" + codigo + ",'" + nombre + "','" + password + "')");


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
         /*  Button entrar = (Button)findViewById(R.id.BEntrar);
            entrar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    // Abrimos BD en modo escritura
                    final SQLiteDatabase bd = dbDatos.getReadableDatabase();
                    EditText usuario = (EditText)findViewById(R.id.nombre);
                    EditText contrasenya = (EditText)findViewById(R.id.contrasenya);

                }
            });
         */

    //  bd.close();
    //}


}
>>>>>>> 598d62b3064f0a063d00e637e91364996848f658
