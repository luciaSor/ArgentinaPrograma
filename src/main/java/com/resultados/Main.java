package com.resultados;

import com.resultados.clases.Apuesta;
import com.resultados.clases.Persona;
import com.resultados.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        String repositorioPartidos = Utils.csvToString("src/main/resources/Hoja de cálculo sin título - Hoja 1.csv");
        String repositorioPronosticos = Utils.csvToString("src/main/resources/Pronosticos Deportivos.csv");
        Set<Persona> apostadores =new HashSet<>();


        System.out.println("Los resultados de los partidos son: ");

        Utils.getPartidos(repositorioPartidos).stream().forEach(System.out::println);

        System.out.println("Las apuestas son las siguientes: ");
        Utils.getPronosticos(repositorioPronosticos).stream().forEach(System.out::println);

        System.out.println("Puntajes obtenidos: ");
        Utils.suma(Utils.getPartidos(repositorioPartidos),Utils.getPronosticos(repositorioPronosticos));

        System.out.println("Puntaje Final: Gabriel 2 puntos ; Gian 3 puntos ; Juana 1 puntos ; Maria 2 puntos ; Martin 4 puntos ; Pedro 3 puntos ; Sebastian 5 puntos; ");

        System.out.println("Felicitaciones, el apostador ganador es: Sebastian");

        System.out.println("Suerte para todos, para la proxima ronda!!!");




    }
}

 


