package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sujic on 09/02/2017.
 */
public class Pedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        Button aceptar = (Button) findViewById(R.id.BAceptar);

        // Creamos bundle para recibir la informacion de la otra pantalla

        Bundle informacion = getIntent().getExtras();

        String totalP = informacion.getSerializable("precioT").toString();
        String totalE = informacion.getSerializable("precioE").toString();
        String posibilidad = informacion.getSerializable("linea").toString();

        TextView precioE = (TextView) findViewById(R.id.precioE);
        TextView precioT = (TextView) findViewById(R.id.precioT);
        TextView posibilidadText = (TextView) findViewById(R.id.posibilidad);

        precioE.setText(totalE+" €");
        precioT.setText(totalP+" €");
        posibilidadText.setText(posibilidad);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(Pedido.this, Fin.class);
                startActivity(ventana);

            }
        });

    }
}
