package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sujic on 11/02/2017.
 */
public class Fin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        Button pedido = (Button) findViewById(R.id.buttonPedido);
        Button local = (Button) findViewById(R.id.buttonLocal);
        Button salir = (Button) findViewById(R.id.buttonSalir);

        pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(Fin.this, Inicio.class);
                startActivity(ventana);
            }
        });

        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(Fin.this, localizacion.class);
                startActivity(ventana);

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                System.exit(0);

            }
        });
    }
}