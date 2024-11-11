package TP5.Punto7;

import java.util.Scanner;
import utils.validaciones;

/**
 * Codificar una implementación de la clase Queue<ELEMENT> (Cola genérica)
 * utilizando en la estructura interna una lista genérica. Usando dicha
 * implementación, solicitar al usuario el ingreso de un número entero N,
 * luego encolar N números aleatorios en la cola.
 * Recorrer la cola mostrando los números ingresados y calcular el
 * promedio de los mismos.
 * Para la implementación de la clase, tener en cuenta los diagramas
 * presentados. En el primer diagrama se muestra el campo interno “list” de la
 * clase Queue<ELEMENT> y en el segundo se
 * presenta los detalles de la clase SimpleLinkedList<ELEMENT>.
 **/
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> cola = new Queue<>();
        agregarElementos(cola, input);
        mostrarElementos(cola);
        calcularPromedio(cola);
    }

    public static void agregarElementos(Queue<Integer> cola, Scanner input) {
        int tamanio = validaciones.validarNumero(input, "Tamaño de la cola: ");

        for (int i = 0; i < tamanio; i++) {
            int num = (int) (Math.random() * 100);
            cola.add(num);
        }
    }

    public static void mostrarElementos(Queue<Integer> cola) {
        Queue<Integer> colaAux = new Queue<>();
        System.out.println("\n------------------------");
        while (!cola.isEmpty()) {
            Integer element = cola.poll();
            System.out.printf(element + " ");
            colaAux.add(element);
        }

        while (!colaAux.isEmpty()) {
            cola.add(colaAux.poll());
        }
        System.out.println("\n-----------------------");
    }

    public static void calcularPromedio(Queue<Integer> cola) {
        int suma = 0;
        double promedio = 0.0;
        Queue<Integer> colaAux = new Queue<>();
        while (!cola.isEmpty()) {
            Integer element = cola.poll();
            suma += element;
            colaAux.add(element);
        }
        while (!colaAux.isEmpty()) {
            cola.add(colaAux.poll());
        }
        promedio = (double) (suma / cola.size());

        System.out.printf("---------\nPromedio: " + promedio + "\n--------------");
    }
}
