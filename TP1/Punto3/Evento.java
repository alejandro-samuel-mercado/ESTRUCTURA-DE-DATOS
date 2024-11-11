package TP1.Punto3;

import java.time.LocalDate;

public class Evento {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Evento() {
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripción";
        this.fechaInicio = LocalDate.now();
        this.fechaFin = this.fechaInicio.plusDays(7);
    }

    public Evento(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String mostrarInfo() {
        String info = "Nombre: " + this.nombre + "---- " + "Descripción: " + this.descripcion + "--- "
                + "Fecha de inicio: " + fechaInicio + "--- " + "Fecha final: " + fechaFin;
        return info;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return this.fechaFin;
    }

}
