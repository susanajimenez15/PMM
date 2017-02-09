package com.example.sujic.proyectofinal_susana;

/**
 * Created by sujic on 08/02/2017.
 */
public class Usuarios {

    String codigo;
        String nombre;
        String contrasenya;

        public Usuarios (String codigo, String nombre, String contrasenya) {

            this.codigo = codigo;
            this.nombre = nombre;
            this.contrasenya = contrasenya;
        }

    public String getCodigo(){

        return codigo;
    }

    public String getNombre(){

        return nombre;
    }

    public String getContrasenya(){

        return contrasenya;
    }

    public void setCodigo(String codigo){

        this.codigo = codigo;
    }


    public void setNombre(String nombre){

        this.nombre = nombre;
    }

    public void setContrasenya(String contrasenya){

        this.contrasenya = contrasenya;
    }




}
