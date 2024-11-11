package TP2.Punto1;

import java.time.LocalDate;

public class Empleado {
    private int cuil;
    private String nombreYApellido;
    private LocalDate fechaIngreso;
    private double sueldo;
    private String departamento;

    public Empleado() {

    }

    public String mostrarDatos(int num) {
        return "Empleado " + num + ": " + "\n" +
                "CUIL: " + this.cuil + "\n" +
                "Nombre y Apellido: " + this.nombreYApellido + "\n" +
                "Fecha de Ingreso: " + this.fechaIngreso + "\n" +
                "Sueldo: " + this.sueldo + "\n" +
                "Departamento: " + this.departamento;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getDepartamento() {
        return departamento;
    }
}
