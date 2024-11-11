package PARCIAL.EjerciciosParcial2;

public class Medico {
    private String nombre;
    private String apellido;
    private String especialidad;
    private Double salario;

    public Medico(String nombre, String apellido, String especialida, Double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialida;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "[" + this.nombre + ", " + this.apellido + ", " + this.especialidad + ", " + this.salario + "]";
    }
}
