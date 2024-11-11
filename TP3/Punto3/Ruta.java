package TP3.Punto3;

public class Ruta {
    private String origen;
    private String destino;
    private Double distanciaRuta;

    public Ruta(String origen, String destino, Double distanciaRuta) {
        this.origen = origen;
        this.destino = destino;
        this.distanciaRuta = distanciaRuta;
    }

    @Override
    public String toString() {
        return "Ruta[Origen: " + origen + ", " + "Destino: " + destino + ", " + "Distancia de la ruta: "
                + distanciaRuta + "]";
    }

}
