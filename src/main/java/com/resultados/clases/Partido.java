package com.resultados.clases;

public class Partido {


    private Equipo equipo1;
    private Equipo equipo2;
    private Boolean ganoEquipo1;

    private Boolean ganoEquipo2;

    private Boolean empate;

    private Integer golesEquipo1;

    private Integer golesEquipo2;





    public Partido (Equipo equipo1, Equipo equipo2, Integer golesEquipo1, Integer golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        if(golesEquipo1 < golesEquipo2){
            this.ganoEquipo1 =false;
            this.ganoEquipo2 = true;
            this.empate=false;
        }else if(golesEquipo1 == golesEquipo2){
            this.ganoEquipo1 =false;
            this.ganoEquipo2 = false;
            this.empate=true;
        }else if(golesEquipo1 > golesEquipo2){
            this.ganoEquipo1 =true;
            this.ganoEquipo2 = false;
            this.empate=false;
        }
    }

    public Partido(){}


    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
    public Integer getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(Integer golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public Integer getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(Integer golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }


    public Boolean getGanoEquipo1() {
        return ganoEquipo1;
    }

    public Boolean getGanoEquipo2() {
        return ganoEquipo2;
    }

    public Boolean getEmpate() {
        return empate;
    }

    @Override
    public String toString() {
        return "Partido: " + equipo1 + " " + golesEquipo1 + " " + golesEquipo2 + " " + equipo2;
    }
}
