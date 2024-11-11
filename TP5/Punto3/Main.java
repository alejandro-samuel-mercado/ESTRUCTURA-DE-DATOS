package TP5.Punto3;

import java.util.Scanner;
import utils.validaciones;
import utils.List.DoublyLinkedLista;
import TP5.Punto3.Deuda;

/**
 * Implementar métodos para eliminar elementos de una lista doblemente enlazada.
 * La lista debe guardar objetos de la clase Deuda con atributos:
 * codigo, descripcion, nombre del acreedor, fecha de la deuda y
 * monto a pagar. El programa debe permitir eliminar una deuda buscada por
 * código o por nombre de acreedor.
 **/

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedLista<Deuda> deudas = new DoublyLinkedLista<>();
        deudasAgregadas(deudas);

        boolean salir = false;
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Eliminar duda por código");
            System.out.println("2. Elminar deuda por Nombre del acreedor ");
            System.out.println("3. Mostrar deudas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");
            opcion = validaciones.validarNumero(input, "");
            switch (opcion) {
                case 1:
                    eliminarPorCodigo(deudas, input);
                    break;
                case 2:
                    eliminarPorNombre(deudas, input);
                    break;
                case 3:
                    System.out.println(deudas.toString());
                    break;
                case 4:
                    System.out.println("Saliendo......");
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (!salir);
    }

    public static void deudasAgregadas(DoublyLinkedLista<Deuda> deudas) {
        Deuda[] deudasSave = {
                new Deuda("D001", "Compra de insumos", "Juan Perez", "10-01-2024", 500.75),
                new Deuda("D002", "Pago de servicios", "Maria Lopez", "15/01/2024", 250.50),
                new Deuda("D003", "Mantenimiento", "Carlos Gomez", "20/01/2024", 300.00),
                new Deuda("D004", "Compra de equipo", "Ana Morales", "25/01/2024", 1000.00),
                new Deuda("D005", "Pago de alquiler", "Luis Fernandez", "30/01/2024", 750.00)
        };
        for (Deuda deuda : deudasSave) {
            deudas.addLast(deuda);
        }
    }

    public static void eliminarPorCodigo(DoublyLinkedLista<Deuda> deudas, Scanner input) {
        System.out.printf("Código a buscar: ");
        String codigo = input.nextLine();

        for (Deuda deuda : deudas) {
            if (deuda.getCodigo().equals(codigo)) {
                deudas.remove(deuda);
                System.out.println("\n-----La deuda con código " + codigo + " ha sido eliminada-----\n");
                break;
            }
        }

    }

    public static void eliminarPorNombre(DoublyLinkedLista<Deuda> deudas, Scanner input) {
        System.out.printf("Nombre del acreedor a buscar: ");
        String nombre = input.nextLine();

        for (Deuda deuda : deudas) {
            if (deuda.getNombreAcreedor().equals(nombre)) {
                deudas.remove(deuda);
                System.out.println("\n-----La deuda del acreedor " + nombre + " ha sido eliminada-----\n");
                break;
            }
        }

    }

}
