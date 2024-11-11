package TP4.Punto4;

public class Visitante {
    private int idVisitante;
    private String aynVisitante;
    private int edad;

    public Visitante(int idVisitante, String aynVisitante, int edad) {
        this.idVisitante = idVisitante;
        this.aynVisitante = aynVisitante;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getAynVisitante() {
        return aynVisitante;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    @Override
    public String toString() {
        return "[Id: " + idVisitante + ", Nombre y Apellido: " + aynVisitante + ", Edad: " + edad;
    }
}
