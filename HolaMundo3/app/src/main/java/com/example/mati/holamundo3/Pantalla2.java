package com.example.mati.holamundo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by mati on 19/09/16.
 */
public class Pantalla2 extends AppCompatActivity {

    public static int COD_RESPUESTA = 0;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final TextView otroSaludo = (TextView) findViewById(R.id.miMensaje);
        final Button botonVolver = (Button) findViewById(R.id.botonVolver);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        botonVolver.setOnClickListener(new View.OnClickListener() {

            public void OnClick(View v){
                Intent miIntent = new Intent(Pantalla2.this, MainActivity3.class);
                startActivityForResult(miIntent, COD_RESPUESTA);
            }
        });
    }




}
