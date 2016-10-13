package com.example.mati.holamundo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText miTexto;
    protected Button miBoton;
    protected TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = (EditText) findViewById(R.id.miTxt);
        miBoton = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //elSaludo.setText("Hola"+miTexto.getText());
                Intent miIntent= new Intent(MainActivity.this, pantalla2.class);
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

            }

       });

        Toast.makeText(this, "Pulsado BOTON", Toast.LENGTH_SHORT).show();
        //showToast("Pulsado BOTON");

    }
}
