package com.resultados.clases;

import java.util.*;

public class Persona {

    private String nombre;
    private Integer puntos = 0;

    private Set<Apuesta> apuestas = new HashSet<>();

    public Persona() {
    }

    public Persona(String nombre, Integer puntos, Set<Apuesta> apuestas) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.apuestas = apuestas;
    }

    public Persona(String nombre, Apuesta apuesta) {
        this.nombre = nombre;
        this.apuestas.add(apuesta);
    }

    public Persona(String nombre, Set<Apuesta> apuestas){
        this.nombre=nombre;
        this.apuestas.addAll(apuestas);
    }


    public Set<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(Set<Apuesta> apuestas) {
        this.apuestas.addAll(apuestas);
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos += puntos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " "+
                "tiene: " + puntos +" "+
                "apuestas" + apuestas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
