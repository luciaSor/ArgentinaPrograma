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


        System.out.println("El resultado de los partidos es:");

        Utils.getPartidos(repositorioPartidos).stream().forEach(System.out::println);

        System.out.println("Las apuestas fueron lassiguientes");

        Utils.verificarApuestas(Utils.getPronosticos(repositorioPronosticos)).stream().forEach(System.out::println);

        System.out.println("Puntajes obtenidos");










    }
}

 


