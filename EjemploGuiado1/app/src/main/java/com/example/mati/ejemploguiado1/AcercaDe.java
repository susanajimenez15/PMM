package com.example.mati.ejemploguiado1;

import android.app.Activity;
import android.os.Bundle;


public class AcercaDe extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layoutque se encuentra en acercade.xml
        setContentView(R.layout.acercade);
    }
}
