package com.resultados.utils;

import com.resultados.clases.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Utils {


public static String csvToString(String path){

        Path filePath = Path.of(path);
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {

            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {

        }

        String fileContent = contentBuilder.toString();



        return fileContent;
    }

    private static Boolean siHayX(String campo) {

    if(campo.equalsIgnoreCase("x")){
        return true;
    } else if (campo.equalsIgnoreCase(" ")){
    return false;
    }
     return null;

    }


  public static Set<Partido> getPartidos(String resultadoRondas){

      Set<Partido> partidos = new HashSet<>();

      String[] formated = resultadoRondas.split("\n");


      for (int i = 1; i < formated.length; i++) {
          String[] reFormated = formated[i].split(",");

          partidos.add(new Partido(new Equipo("Argentina", reFormated[1]),new Equipo("Argentina", reFormated[4]),Integer.valueOf(reFormated[2]),Integer.valueOf(reFormated[3])));

      }


      return partidos;

  }





  public static Set<Persona> getPronosticos(String resultadoPronosticos) {

      Set<Persona> apostadores = new HashSet<>();

      String[] formated = resultadoPronosticos.split("\n");


      for (int i = 1; i < formated.length; i++) {
          String[] reFormated = formated[i].split(",");
         Apuesta apuesta = new Apuesta(new Equipo("Argentina", reFormated[1]),new Equipo("Argentina", reFormated[5]),siHayX(reFormated[2]),siHayX(reFormated[4]),siHayX(reFormated[3]));
         apostadores.add(new Persona(reFormated[0],apuesta));

      }




      return apostadores;
  }

  /*public static Set<Persona> verificarApuestas(Set<Persona> apostantes){
    Set<Persona> personas = new HashSet<>();
    Set<Persona> personas1 = new HashSet<>();

   for (Persona apostante: apostantes) {
        if(personas1.isEmpty()){
            personas1.addAll(apostantes);
        }else {
            for (Persona persona:personas1){
                if (persona.getNombre().equals(apostante.getNombre())){
                    Set<Apuesta>apuestas = new HashSet<>();
                    apuestas.addAll(apostante.getApuestas());
                    apuestas.addAll(persona.getApuestas());
                    personas.add(new Persona(persona.getNombre(),apuestas));
                }else {
                    personas.add(persona);
                }

            }




        }

    }





    return personas;
  }*/


    public static Persona contarPuntos(Set<Partido> partidos , Persona persona){
        Persona persona1 = new Persona(persona.getNombre());

        for (Partido patido :partidos){
            for (Apuesta apuesta : persona.getApuestas()){
                if (apuesta.getEquipo1().getNombre().equals(patido.getEquipo1().getNombre())){
                    if(apuesta.getGanaEquipo1().equals(patido.getGanoEquipo1())  && apuesta.getGanaEquipo2().equals(patido.getGanoEquipo2()) && apuesta.getEmpate().equals(patido.getEmpate())){
                        persona1.setPuntos(1);
                        persona1.setApuestas(persona.getApuestas());
                    }else {persona1.setPuntos(0);persona1.setApuestas(persona.getApuestas());}
                }
            }

        }
        return persona1;
    }


    public static void suma(Set<Partido> partidos, Set<Persona> personas){
        Set<Persona> personas1 = new HashSet<>();
        personas.stream().forEach(persona -> {
            personas1.add(contarPuntos(partidos,persona));
        });



         personas1.stream().sorted(Comparator.comparing(Persona::getNombre)).forEach(System.out::println);
    }












}






