package com.example.mati.ejemploejerciciorecopilatorio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private destino[] datos = new destino[]{
            new destino("Zona A: ", "Asia y Oceanía", 30),
            new destino("Zona B: ", "América y África", 20),
            new destino("Zona C: ", "Europa", 10)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para rellenear el spinner
        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        Spinner istOpciones = (Spinner) findViewById(R.id.zonas);
        istOpciones.setAdapter(adaptador);
    }
    //Menu de Arcerca DE y dibujar
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, acercade.class);
                startActivity(acerca);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Rellenando el spinner
    public class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context){
            super(context, R.layout.listitem_destino, datos);
            this.context = context;
        }
        public  View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_destino, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblZona);
            lblTitulo.setText(datos[i].getzona());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblContinente);
            lblSubtitulo.setText(datos[i].getcontinente());

            TextView lblPrecio = (TextView)item.findViewById(R.id.LblPrecio);
            lblPrecio.setText(String.valueOf(datos[i].getPrecio()) + "€");

            return (item);
        }

    }
}
