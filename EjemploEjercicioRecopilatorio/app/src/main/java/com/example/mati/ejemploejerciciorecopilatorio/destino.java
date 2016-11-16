package com.example.mati.ejemploejerciciorecopilatorio;

public class destino {
    private static String zona;
    private static String continente;
    private static double precio;

    public destino (String zona, String continente, double precio){
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
    }

    public static String getzona (){
        return zona;
    }
    public static String getcontinente (){
        return continente;
    }
    public static double getPrecio (){
        return precio;
    }
}
