package com.example.mati.linearlayoutejercicio1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioButton verde = (RadioButton) findViewById(R.id.vbutton);
        RadioButton rojo = (RadioButton) findViewById(R.id.rbutton);
        RadioButton azul = (RadioButton) findViewById(R.id.abutton);

        Button añadir = (Button) findViewById(R.id.acolor);
        Button borrar = (Button) findViewById(R.id.borrar);

        final TextView textView = (TextView) findViewById(R.id.color);

        final RadioGroup grupoBotones = (RadioGroup) findViewById(R.id.rgcolor);

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grupoBotones.getCheckedRadioButtonId() == R.id.rbutton ){
                    int crojo = Color.parseColor("#ff0000");
                    textView.setBackgroundColor(crojo);
                }
                if (grupoBotones.getCheckedRadioButtonId() == R.id.vbutton){
                    int cverde = Color.parseColor("#76e163");
                    textView.setBackgroundColor(cverde);
                }
                if(grupoBotones.getCheckedRadioButtonId() == R.id.abutton){
                    int cazul = Color.parseColor("#429bf4");
                    textView.setBackgroundColor(cazul);
                }


            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorBorrar = Color.parseColor("#ffffff");
                textView.setBackgroundColor(colorBorrar);

            }
        });
    }


}
