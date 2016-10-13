package com.example.mati.objectoentrepantallas;


public class Persona {

    String nombre;
    String apellidos;
    int edad;

    public Persona (String nombre, String apellidos, int edad)
    {
        nombre = this.nombre;
        apellidos = this.apellidos;
        edad = this.edad;
    }

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }
}
