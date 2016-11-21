package com.example.mati.ejemploejerciciorecopilatorio;

import java.io.Serializable;

public class Coche implements Serializable{
    private  String zona;
    private  String continente;
    private  double precio;
    private int img;

    public Coche (String zona, String continente, double precio, int imagen){
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
        this.img = imagen;
    }

    public  String getzona (){
        return zona;
    }
    public  String getcontinente (){
        return continente;
    }
    public  double getPrecio (){
        return precio;
    }
    public  int getInt(){ return img; }
}
