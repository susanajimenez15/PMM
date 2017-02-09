package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by sujic on 23/01/2017.
 */
public class Inicio  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);



        // Menu Acerca De y Información

    /**    public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.activity_menu, menu);
            return true;
        }
        public boolean onOptionItemSelected(MenuItem item){
            switch(item.getItemId()){
                case R.id.acerca:
                    Intent acerca = new Intent(Inicio.this, acercade.class);
                    startActivity(acerca);
                    return true;
                case R.id.informacion:
                    Intent info = new Intent(Inicio.this, informacion.class);
                    startActivity(info);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
     **/
    }


}
