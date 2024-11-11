package PARCIAL.Resuelto;

import java.util.Scanner;

import TP5.Punto1.SingleLinkedList;
import utils.BinaryTree.BinarySearchTree;
import utils.BinaryTree.BinaryTree;
import utils.List.DoublyLinkedLista;

public class Parcial2 {

    public static void main(String[] args) {
        DoublyLinkedLista<Localidad> localidades = new DoublyLinkedLista<>();

        Scanner input = new Scanner(System.in);
        cargarLocalidades(localidades);
        float promedio = promedioSegunRegion(localidades, input);
        System.out.println("Promedio: " + promedio);

        ///////////////////////
        System.out.println(localidades.ultimoElemento());

        ///////////////////////
        DoublyLinkedLista<Localidad> nuevaLista = nuevaslistaLocalidades(localidades);
        System.out.println(nuevaLista.toString());

        /////////////////
        BinaryTree<Integer> node38 = new BinaryTree<>(38, new BinaryTree<>(37), null);
        BinaryTree<Integer> node35 = new BinaryTree<>(35, null, node38);
        BinaryTree<Integer> node30 = new BinaryTree<>(30, new BinaryTree<>(27), node35);
        BinaryTree<Integer> node25 = new BinaryTree<>(25, null, node30);

        BinaryTree<Integer> node50 = new BinaryTree<>(50, new BinaryTree<>(48), null);
        BinaryTree<Integer> node45 = new BinaryTree<>(45, null, node50);
        BinaryTree<Integer> node40 = new BinaryTree<>(40, node25, node45);
        BinaryTree<Integer> node60 = new BinaryTree<>(60, node40, new BinaryTree<>(70));

        node60.preOrder();
        System.out.println("");
        System.out.println(node60.toString());
    }

    public static float promedioSegunRegion(DoublyLinkedLista<Localidad> localidades, Scanner input) {
        float promedio = 0;
        float suma = 0;
        int count = 0;

        String regionBuscada = input.nextLine();
        for (Localidad localidad : localidades) {
            if (localidad.getRegion().equalsIgnoreCase(regionBuscada)) {
                suma += localidad.getSuperficie();
                count++;
            }
        }
        promedio = (float) (suma / count);
        return promedio;
    }

    public static String localidadConMayorCantHab(DoublyLinkedLista<Localidad> localidades) {
        String regionConMayorCantidad = "";
        int mayor = 0;
        for (Localidad localidad : localidades) {
            if (localidad.getHabitantes() > mayor) {
                mayor = localidad.getHabitantes();
                regionConMayorCantidad = localidad.getRegion();
            }
        }
        return regionConMayorCantidad;
    }

    public static DoublyLinkedLista<Localidad> nuevaslistaLocalidades(DoublyLinkedLista<Localidad> localidades) {
        String regionConMayorCantidad = localidadConMayorCantHab(localidades);
        DoublyLinkedLista<Localidad> nuevaLista = new DoublyLinkedLista<>();
        for (Localidad localidad : localidades) {
            if (localidad.getRegion().equals(regionConMayorCantidad)) {
                nuevaLista.addLast(localidad);
            }
        }
        return nuevaLista;
    }

    public static void cargarLocalidades(DoublyLinkedLista<Localidad> localidades) {
        Localidad[] arrayLocalidades = {
                new Localidad("Susques", 1000, 10),
                new Localidad("Volcan", 500, 20),
                new Localidad("Susques", 1000, 20),
                new Localidad("Susques", 1000, 10),
                new Localidad("Susques", 2000, 40),
                new Localidad("Ssj", 50000, 50),
                new Localidad("Ssj", 20000, 50)
        };

        for (Localidad localidad : arrayLocalidades) {
            localidades.addLast(localidad);
        }
    }
}