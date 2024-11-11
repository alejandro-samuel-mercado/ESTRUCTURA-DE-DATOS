package TP06_Arboles.Punto3;

public class Juguete implements Comparable<Juguete> {
    private String nombre;
    private String descripcion;
    private String tipoMaterial;
    private double precio;

    public Juguete(String nombre, String descripcion, String tipoMaterial, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoMaterial = tipoMaterial;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "[" + this.nombre + ", " + this.descripcion + ", " + this.tipoMaterial + ", " + this.precio + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Juguete otroJuguete) {

        return Double.compare(this.precio, otroJuguete.precio);

    }

}
