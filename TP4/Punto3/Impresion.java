package TP4.Punto3;

/**
 * Impresion
 */
public class Impresion {
    private int codTrabajo;
    private String nomTrabajo;
    private int cantPagTrabajo;

    public Impresion(String nomTrabajo, int cantPagTrabajo) {
        codTrabajo = (int) (Math.random() * 100);
        this.nomTrabajo = nomTrabajo;
        this.cantPagTrabajo = cantPagTrabajo;
    }

    public int getCantPagTrabajo() {
        return cantPagTrabajo;
    }

    @Override
    public String toString() {
        return "Trabajo[Codigo: " + codTrabajo + ", Nombre del Trabajo: " + nomTrabajo
                + ", Cantidad de páginas: " + cantPagTrabajo;
    }

}