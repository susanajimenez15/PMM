package com.example.sujic.proyectofinal_susana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

/**
 * Created by sujic on 10/02/2017.
 */
public class quees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_info);

        Button volver = (Button) findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent ventana = new Intent(quees.this, Login.class);
                startActivity(ventana);

            }
        });
    }

}
