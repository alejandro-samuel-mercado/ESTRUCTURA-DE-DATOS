package PARCIAL.Resuelto;

import PARCIAL.EjerciciosParcial2.punto4;

public class Localidad {
    private String localidad;
    private int habitantes;
    private float superficie;

    public Localidad(String localidad, int habitantes, float superficie) {
        this.localidad = localidad;
        this.habitantes = habitantes;
        this.superficie = superficie;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public String getRegion() {
        return localidad;
    }

    public float getSuperficie() {
        return superficie;
    }

    @Override
    public String toString() {
        return "[" + this.localidad + ", " + this.habitantes + ", " + this.superficie + "]";
    }
}
