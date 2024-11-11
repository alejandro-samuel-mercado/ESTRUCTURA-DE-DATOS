package PARCIAL.Resuelto;

import java.time.LocalDate;

public class Empleado {
    private int legajo;
    private int dni;
    private String nombre;
    private String fechaNacimiento;
    private String correo;
    private int edad;
    private Double saldo;

    public Empleado(int legajo, int dni, String nombre, String fecha, String correo, int edad, Double saldo) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.correo = correo;
        this.edad = edad;
        this.saldo = saldo;
    }

    public int getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaNacimiento() {
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

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Empleado[ Legajo: " + this.legajo + ", Dni: " + this.dni + ", Nombre: " + this.nombre
                + ", Fecha de nacimiento: " + this.fechaNacimiento + ", Correo: " + this.correo + " ]";
    }

}
