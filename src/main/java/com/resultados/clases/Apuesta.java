package com.resultados.clases;


public class Apuesta {

    private Equipo equipo1;

    private Equipo equipo2;

    private Boolean ganaEquipo1;

    private Boolean ganaEquipo2;

    private Boolean empate;

    public Apuesta(){}

    public Apuesta(Equipo equipo1, Equipo equipo2, Boolean ganaEquipo1, Boolean ganaEquipo2, Boolean empate) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganaEquipo1 = ganaEquipo1;
        this.ganaEquipo2 = ganaEquipo2;
        this.empate = empate;
    }

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

    public Boolean getGanaEquipo1() {
        return ganaEquipo1;
    }

    public void setGanaEquipo1(Boolean ganaEquipo1) {
        this.ganaEquipo1 = ganaEquipo1;
    }

    public Boolean getGanaEquipo2() {
        return ganaEquipo2;
    }

    public void setGanaEquipo2(Boolean ganaEquipo2) {
        this.ganaEquipo2 = ganaEquipo2;
    }

    public Boolean getEmpate() {
        return empate;
    }

    public void setEmpate(Boolean empate) {
        this.empate = empate;
    }

    @Override
    public String toString() {
        return
                ", equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", ganaEquipo1=" + ganaEquipo1 +
                ", ganaEquipo2=" + ganaEquipo2 +
                ", empate=" + empate;
    }


}
