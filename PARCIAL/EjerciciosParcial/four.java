package PARCIAL.EjerciciosParcial;

import utils.Queue.SpeedQueue;

/**
 * Escribir una función o método que reciba como parámetros una cola circular y
 * un valor. Como resultado se debe devolver una cola circular en la que se
 * hayan eliminado todas las apariciones del valor.
 **/

public class four {
    public static void main(String[] args) {
        SpeedQueue<Integer> colaC = new SpeedQueue<>();
        colaC.add(0);
        colaC.add(3);
        colaC.add(6);
        colaC.add(3);
        colaC.add(1);
        colaC.add(7);

        eliminarApariciones(colaC, 3);
    }

    public static void eliminarApariciones(SpeedQueue<Integer> colaC, int valor) {
        SpeedQueue<Integer> nuevaCola = new SpeedQueue<>();

        while (!colaC.isEmpty()) {
            Integer elemento = colaC.poll();
            if (!elemento.equals(valor)) {
                nuevaCola.add(elemento);
            }
        }

        while (!nuevaCola.isEmpty()) {
            System.out.printf(nuevaCola.poll() + " ");
        }
    }

}
