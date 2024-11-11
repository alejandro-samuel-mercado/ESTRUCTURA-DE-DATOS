package TP5.Punto6;

import utils.List.*;

import java.util.Queue;
import java.util.Scanner;
import utils.validaciones;
import utils.Queue.*;

/**
 * Implementar un método que elimine todos los elementos duplicados de una lista
 * enlazada, dejando elementos únicos. La lista de elementos puede ser simple
 * o doblemente enlazada.
 **/
public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> elements = new SingleLinkedList<>();

        boolean salir = false;
        Scanner input = new Scanner(System.in);
        agregarElementos(elements, input);
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Eliminar duplicados ");
            System.out.println("3. Salir");
            opcion = validaciones.validarNumero(input, "Seleccione una opción:\n---------------------\n ");
            switch (opcion) {
                case 1:
                    elements.mostrar();
                    break;
                case 2:
                    // elements.removeDuplicate();
                    elements = eliminarDuplicados(elements);
                    break;
                case 3:
                    System.out.println("Saliendo......");
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (!salir);
    }

    public static void agregarElementos(SingleLinkedList<Integer> elements, Scanner input) {
        int cantidad = validaciones.validarNumero(input, "Cantidad a ingresar: ");
        for (int i = 0; i < cantidad; i++) {
            int num = input.nextInt();
            elements.addLast(num);
        }

    }

    public static SingleLinkedList<Integer> eliminarDuplicados(SingleLinkedList<Integer> elements) {
        SingleLinkedList<Integer> temp = new SingleLinkedList<>();

        for (Integer num1 : elements) {
            boolean existe = false;
            if (!temp.isEmpty()) {
                for (Integer num2 : temp) {
                    if (num1.equals(num2)) {
                        existe = true;
                    }
                }
            }

            if (!existe) {
                temp.addLast(num1);
            }
        }
        return temp;
    }

}
