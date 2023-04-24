package com.resultados.utils;

import java.io.FileWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class ArchivosBD {

    public static void main(String argumentos[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/partidos","root","admin");

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT Ronda, Equipo1, Cant_Goles1, Cant_Goles2, Equipo2 FROM resultados");
            FileWriter fileWriter = new FileWriter("C://Users//sors//Documents//GitHub//ArgentinaPrograma//src//main//resources//Hoja de cálculo sin título - Hoja 1 - copia.csv");
            while (resultSet.next()) {

                fileWriter.append(resultSet.getString("Ronda"));
                fileWriter.append(",");
                fileWriter.append(resultSet.getString("Equipo1"));
                fileWriter.append(",");
                fileWriter.append(resultSet.getString("Cant_Goles1"));
                fileWriter.append(",");
                fileWriter.append(resultSet.getString("Cant_Goles2"));
                fileWriter.append(",");
                fileWriter.append(resultSet.getString("Equipo2"));
                fileWriter.append("\n");
            }
            fileWriter.close();


            con.close();
        } catch(Exception e){
            System.out.println("Error no se encuentra la Base de Datos! e = " +e);
            System.out.println(e);}
    }

}
