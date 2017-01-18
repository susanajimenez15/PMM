package com.example.mati.basededatos1;

/**
 * Created by mati on 11/01/17.
 */

public class Cliente {

    String nombre;
    String telefono;

    public Cliente (String nombre, String telefono){

        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

}
