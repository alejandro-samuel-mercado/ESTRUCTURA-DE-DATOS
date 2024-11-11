package TP3.Punto3;

import utils.validaciones;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        GPS gps = new GPS();

        do {
            int opcion = validaciones.validarNumIntEnVentana("INGRESE UNA OPCION" + "\n" + "------------" + "\n" +
                    "1-Agregar nueva ruta" + "\n" +
                    "2-Deshacer ruta agregada" + "\n" +
                    "3-Rehacer ruta " + "\n" +
                    "4-Ver ruta actual (última)" + "\n" +
                    "5-Ver historial completo" + "\n" +
                    "6-Salir");

            switch (opcion) {
                case 1:
                    agregarRuta(gps);
                    break;
                case 2:
                    gps.deshacerRuta();
                    break;
                case 3:
                    gps.rehacerRuta();
                    break;
                case 4:
                    gps.verRutaActual();
                    break;
                case 5:
                    gps.verHistorialCompleto();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción correcta");

                    break;
            }

        } while (!salir);

    }

    public static void agregarRuta(GPS gps) {
        String origen = validaciones.validarTextoVentana("Origen de ruta");
        String destino = validaciones.validarTextoVentana("Destino de la ruta");
        Double distanciaRuta = validaciones.validarNumDoubleEnVentana("Distancia de la ruta en Kilómetros");

        Ruta nuevaRuta = new Ruta(origen, destino, distanciaRuta);
        gps.agregarRuta(nuevaRuta);
    }
}
