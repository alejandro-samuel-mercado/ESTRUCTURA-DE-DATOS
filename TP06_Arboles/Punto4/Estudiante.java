package TP06_Arboles.Punto4;

public class Estudiante implements Comparable<Estudiante> {
    private String apellido;
    private String nombre;
    private int lu;
    private String carrera;
    private int añoIngreso;

public Estudiante(){

}

    public Estudiante(String apellido, String nombre, int lu, String carrera, int añoIngreso) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.lu = lu;
        this.carrera = carrera;
        this.añoIngreso = añoIngreso;
    }

    @Override
    public String toString() {
        return "[" + this.lu + ", " + this.apellido + ", " + this.nombre + ", " + this.carrera + ", " + this.añoIngreso
                + " ]";
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getLu() {
        return lu;
    }

    public int compareTo(Estudiante other) {

        return Double.compare(this.lu, other.lu);

    }

}
