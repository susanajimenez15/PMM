package com.example.mati.holamundo3;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends Activity {

    public static int COD_RESPUESTA = 0;
    TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);

        //Borrar texto inicial de EditText
        miTexto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean b) {
                if (b) miTexto.setText("");
            }
        });


        miBoton.setOnClickListener(new View.OnClickListener()

                                   {
                                       public void onClick(View v) {
                                           Intent miIntent = new Intent(MainActivity3.this, Pantalla2.class);
                                           Bundle miBundle = new Bundle();
                                           String mensajePaso = "Te saludo" + miTexto.getText();
                                           miBundle.putString("TEXTO", mensajePaso);
                                           miIntent.putExtras(miBundle);
                                           startActivityForResult(miIntent, COD_RESPUESTA);
                                       }
                                   }

        );

    }

    public void onActivityResult(int cod_resp, int cod_result, Intent intent) {
        if (cod_resp == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }
}




