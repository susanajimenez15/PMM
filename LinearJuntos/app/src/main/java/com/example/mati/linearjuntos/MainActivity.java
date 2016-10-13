package com.example.mati.linearjuntos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    protected Button lineal;
    protected Button tabla;
    protected Button grid;
    protected Button relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineal = (Button) findViewById(R.id.botonLineal);
        tabla = (Button) findViewById(R.id.botonTabla);
        grid = (Button) findViewById(R.id.botonGrid);
        relative = (Button) findViewById(R.id.botonRelativo);

        final Intent intentoLineal = new Intent(this, LinearLinear.class);
        final Intent intentoTabla = new Intent(this, LinearTabla.class);
        final Intent intentoGrid = new Intent(this, LinearGrid.class);
        final Intent intentoRelative = new Intent(this, LinearRealtive.class);

        lineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentoLineal);
            }
        });

        tabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentoTabla);
            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentoGrid);
            }
        });

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentoRelative);
            }
        });

    }




}
