package TP5.Punto1;

import java.time.LocalDate;

public class Empleado {
    private int legajo;
    private int dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String correo;
    private int edad;

    public Empleado(int legajo, int dni, String nombre, LocalDate fecha, String correo, int edad) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.correo = correo;
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Empleado[ Legajo: " + this.legajo + ", Dni: " + this.dni + ", Nombre: " + this.nombre
                + ", Fecha de nacimiento: " + this.fechaNacimiento + ", Correo: " + this.correo + " ]";
    }

}
