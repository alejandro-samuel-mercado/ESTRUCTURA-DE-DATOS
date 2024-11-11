package TP5.Punto4;

import java.util.Comparator;

import utils.List.SingleLinkedLista;

/**
 * Crear un programa que permita combinar dos listas enlazadas ordenadas de
 * números enteros en una sola, manteniendo el orden de los elementos.
 **/
public class Main {
    public static void main(String[] args) {
        SingleLinkedLista<Integer> lista1 = new SingleLinkedLista<>();
        SingleLinkedLista<Integer> lista2 = new SingleLinkedLista<>();
        SingleLinkedLista<Integer> lista3 = new SingleLinkedLista<>();
        listasAgregadas(lista1, lista2);
        unirListasEnOrden(lista1, lista2, lista3);
    }

    public static void listasAgregadas(SingleLinkedLista<Integer> lista1, SingleLinkedLista<Integer> lista2) {
        for (int i = 0; i < 5; i++) {
            int num = (int) (Math.random() * 100);
            lista1.addInOrder(num);
        }
        System.out.println("Lista 1: ");
        System.out.println(lista1.toString());
        System.out.println("-----------------------\n");

        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random() * 100);
            lista2.addInOrder(num);
        }
        System.out.println("Lista 2: ");
        System.out.println(lista2.toString());
        System.out.println("-----------------------\n");
    }

    public static void unirListasEnOrden(SingleLinkedLista<Integer> lista1, SingleLinkedLista<Integer> lista2,
            SingleLinkedLista<Integer> lista3) {
        for (Integer num : lista1) {
            lista3.addInOrder(num);
        }
        for (Integer num : lista2) {
            lista3.addInOrder(num);
        }
        System.out.println("Lista 3 (Unión de lista 1 y lista 2): ");
        System.out.println(lista3.toString());
        System.out.println("-----------------------\n");

    }
}
