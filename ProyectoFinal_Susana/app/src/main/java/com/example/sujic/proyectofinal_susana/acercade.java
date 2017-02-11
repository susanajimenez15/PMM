package com.example.sujic.proyectofinal_susana;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sujic on 31/01/2017.
 */

public class acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);


        Button volver = (Button) findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ventana = new Intent(acercade.this, Login.class);
                startActivity(ventana);

            }
        });

    }
}
