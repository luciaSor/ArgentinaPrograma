package com.resultados.clases;

public class Equipo {

    private String nombre;

    public Equipo(){}


    public Equipo(String argentina, String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
