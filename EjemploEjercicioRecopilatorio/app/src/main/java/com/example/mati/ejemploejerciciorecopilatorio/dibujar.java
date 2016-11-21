package com.example.mati.ejemploejerciciorecopilatorio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new dibujo (this));


        }

    public class dibujo extends View {
        public dibujo(Context contexto){
            super(contexto);
        }

        protected void onDraw(Canvas canvas){


            Paint ventana = new Paint();
            ventana.setColor(Color.BLUE);
            ventana.setStrokeWidth(30);
            ventana.setStyle(Paint.Style.STROKE);
            canvas.drawRect(700,300,1000,500, ventana);

            Paint cuadro = new Paint();
            cuadro.setColor(Color.BLACK);
            cuadro.setStrokeWidth(30);
            cuadro.setStyle(Paint.Style.STROKE);
            canvas.drawRect(150,300,1000,650, cuadro);

            Paint circulo = new Paint();
            circulo.setColor(Color.BLACK);
            circulo.setStrokeWidth(30);
            circulo.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,650,100,circulo);

            Paint circulo2 = new Paint();
            circulo2.setColor(Color.BLACK);
            circulo2.setStrokeWidth(30);
            circulo2.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(1000,650,100,circulo2);

        }
    }

    }







