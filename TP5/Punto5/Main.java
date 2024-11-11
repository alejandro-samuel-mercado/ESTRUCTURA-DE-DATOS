package TP5.Punto5;

import java.util.Scanner;

import utils.validaciones;
import utils.List.DoublyLinkedList;

/**
 * Desarrollar métodos para recorrer una lista doblemente enlazada en ambas
 * direcciones. El usuario debe elegir en qué sentido recorrer la lista.
 * Al recorrer se deben mostrar los elementos de la lista sin eliminarlos.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedList<Integer> lista1 = new DoublyLinkedList<>();
        listasAgregadas(lista1, input);
        boolean salir = false;
        int opcion;

        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Recorrer lista hacia adelante");
            System.out.println("2. Recorrer lista hacia atrás");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");

            opcion = validaciones.validarNumero(input, "");
            switch (opcion) {
                case 1:
                    travelNext(lista1);
                    // lista1.travelNext();
                    break;
                case 2:
                    travelBack(lista1);
                    // lista1.travelBack();
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

    public static void listasAgregadas(DoublyLinkedList<Integer> lista1, Scanner input) {
        for (int i = 0; i < 10; i++) {
            int num = input.nextInt();
            lista1.addLast(num);
        }
    }

    public static void travelNext(DoublyLinkedList<Integer> lista1) {
        DoublyLinkedList<Integer> aux = new DoublyLinkedList<>();
        while (!lista1.isEmpty()) {
            Integer element = lista1.removeFirst();
            System.out.printf(element + " ");
            System.out.println("");

            aux.addLast(element);
        }

        while (!aux.isEmpty()) {
            lista1.addLast(aux.removeFirst());
        }
    }

    public static void travelBack(DoublyLinkedList<Integer> lista1) {
        DoublyLinkedList<Integer> aux = new DoublyLinkedList<>();
        while (!lista1.isEmpty()) {
            Integer element = lista1.removeLast();
            System.out.printf(element + " ");
            System.out.println("");

            aux.addFirst(element);
        }

        while (!aux.isEmpty()) {
            lista1.addLast(aux.removeFirst());
        }
    }

}