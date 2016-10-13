package com.example.mati.objectoentrepantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombreEdit = (EditText) findViewById(R.id.editNombre);
        EditText apellidoseEdit = (EditText) findViewById(R.id.editApellidos);
        EditText edadEdit = (EditText) findViewById(R.id.editEdad);
        


        Bundle Datospersona = new Bundle();

        Datospersona = getIntent().getExtras();

        Persona persona = (Persona)




    }
}
