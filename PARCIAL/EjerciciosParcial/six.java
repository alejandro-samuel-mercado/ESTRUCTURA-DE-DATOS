package PARCIAL.EjerciciosParcial;

import utils.Queue.SpeedQueue;

/**
 * Crear un método que recibe dos colas circulares y devuelve una cola circular
 * con los elementos intercalados de amabas colas. Debe tenerse en cuenta que no
 * deben haber valores repetidos.
 **/
public class six {
    public static void main(String[] args) {
        SpeedQueue<Integer> cola1 = new SpeedQueue<>();
        SpeedQueue<Integer> cola2 = new SpeedQueue<>();

        cola1.add(1);
        cola1.add(3);
        cola1.add(5);
        cola1.add(7);
        cola1.add(7);
        cola2.add(2);
        cola2.add(4);
        cola2.add(6);
        cola2.add(8);
        cola2.add(10);

        intercalar(cola1, cola2);

    }

    public static void intercalar(SpeedQueue<Integer> cola1,
            SpeedQueue<Integer> cola2) {

        SpeedQueue<Integer> colaIntercalada = new SpeedQueue<>();

        while (!cola1.isEmpty() || !cola2.isEmpty()) {
            if (!cola1.isEmpty()) {
                colaIntercalada.add(cola1.poll());
            }
            if (!cola2.isEmpty()) {
                colaIntercalada.add((cola2.poll()));
            }
        }
        mostrar(colaIntercalada);
        eliminarDuplicados(colaIntercalada);
        mostrar(colaIntercalada);
    }

    public static void eliminarDuplicados(SpeedQueue<Integer> colaIntercalada) {
        int[] arrayAux = new int[colaIntercalada.size()];
        int pos = 0;
        while (!colaIntercalada.isEmpty()) {
            Integer element = colaIntercalada.poll();
            boolean duplicado = false;

            for (int i = 0; i < arrayAux.length; i++) {
                if (element.equals(arrayAux[i])) {
                    duplicado = true;
                    break;
                }

            }
            if (!duplicado) {
                arrayAux[pos] = element;
                pos++;
            }

        }

        for (int i = 0; i < arrayAux.length; i++) {
            colaIntercalada.add(arrayAux[i]);
        }
    }

    public static void mostrar(SpeedQueue<Integer> colaIntercalada) {
        SpeedQueue<Integer> aux = new SpeedQueue<>();

        while (!colaIntercalada.isEmpty()) {
            Integer element = colaIntercalada.poll();
            System.out.printf(element + " ");
            aux.add(element);
        }
        System.out.println("");

        while (!aux.isEmpty()) {
            colaIntercalada.add(aux.poll());
        }
    }

}
