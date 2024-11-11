package TP1.Punto5;

public class ContenidoMultimedia {
    private String titulo;
    private String director;
    private int año;
    private int duracion;
    private boolean disponible;

    public ContenidoMultimedia(String titulo, String director, int año, int duracion, boolean disponible) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.disponible = disponible;
    }

    public void mostrarDatos() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Director: " + this.director);
        System.out.println("Año: " + this.año);
        System.out.println("Duración: " + this.duracion + " minutos");
        System.out.println("Disponible: " + (estaDisponible()));
    }

    public String estaDisponible() {
        String estaDisponible = "si";
        if (!this.disponible) {
            estaDisponible = "no";
        }
        return estaDisponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAño() {
        return año;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean getIsDisponible() {
        return disponible;
    }

}
