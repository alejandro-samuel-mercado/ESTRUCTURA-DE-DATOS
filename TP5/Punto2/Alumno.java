package TP5.Punto2;

import java.time.LocalDate;

public class Alumno {
    private int lu;
    private int dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private String correo;

    public Alumno(int lu, int dni, String nombre, LocalDate fecha, LocalDate fechaIngreso, String correo) {
        this.lu = lu;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.fechaIngreso = fechaIngreso;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public int getDni() {
        return dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getLu() {
        return lu;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[LU: " + this.lu + ", DNI: " + this.dni + ", Nombre: " + this.nombre + ", Fecha de Nacimiento: "
                + this.fechaNacimiento + ", Fecha de ingreso: " + this.fechaIngreso + ", Correo: " + this.correo + "]";
    }

}
