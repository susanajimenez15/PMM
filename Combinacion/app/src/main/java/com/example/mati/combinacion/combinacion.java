package com.example.mati.combinacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class combinacion extends AppCompatActivity {
    protected Button boton1;
    protected TextView miTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinacion);

        boton1 =(Button) findViewById(R.id.button);
        miTexto = (TextView) findViewById(R.id.textview);

        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                miTexto.setText("Has pulsado el boton");
            }
        });
    }
}
