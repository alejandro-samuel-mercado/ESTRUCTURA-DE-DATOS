package PARCIAL.EjerciciosParcial;

import utils.Queue.SpeedQueue;
import utils.Stack.*;;

/**
 * Dada una cola circular devolver la cola circular invertida, la función recibe
 * una cola circular, utiliza una pila genérica en el proceso.
 * la función retorna una cola circular.
 **/
public class one {

    public static void main(String[] args) {
        SpeedQueue<Integer> colaC = new SpeedQueue<>();
        colaC.add(1);
        colaC.add(2);
        colaC.add(3);
        colaC.add(4);
        colaC.add(5);
        invertirCola(colaC);

    }

    public static SpeedQueue<Integer> invertirCola(SpeedQueue<Integer> colaC) {
        SpeedQueue<Integer> colaInvertida = new SpeedQueue<>();
        Stack<Integer> pilaAux = new Stack<>();

        while (!colaC.isEmpty()) {
            pilaAux.push(colaC.poll());
        }
        while (!pilaAux.isEmpty()) {
            colaInvertida.add(pilaAux.pop());
        }
        return colaInvertida;
    }
}
