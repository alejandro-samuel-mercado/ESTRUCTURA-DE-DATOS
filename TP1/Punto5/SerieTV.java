package TP1.Punto5;

public class SerieTV extends ContenidoMultimedia {
    private int temporadas;
    private String genero;

    public SerieTV(String titulo, String director, int año, int duracion, boolean disponible, int temporadas,
            String genero) {
        super(titulo, director, año, duracion, disponible);
        this.temporadas = temporadas;
        this.genero = genero;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Género: " + genero);
    }

    public String getGenero() {
        return this.genero;
    }
}
