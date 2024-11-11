package TP4.Punto3;

import TP4.Punto2.ColaCircular;
import utils.validaciones;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ColaCircular<Impresion> trabajoImpresion = new ColaCircular<>(10);
        ColaCircular<Impresion> colaAuxiliar = new ColaCircular<>(10);
        Scanner input = new Scanner(System.in);

        boolean salir = false;
        do {
            System.out.println("\n--- Menú Gestión Impresora ---");
            System.out.println("1. Añadir trabajo de impresión");
            System.out.println("2. Imprimir el primer trabajo colocado en la fila");
            System.out.println("3. Imprimir todos los trabajos");
            System.out.println("4. Mostrar trabajos de impresión");
            System.out.println("5. Mostrar trabajos impresos con más de X páginas");
            System.out.println("6. Salir");

            int opcion = validaciones.validarNumero(input, "Seleccione una opción:\n--------------------- ");
            switch (opcion) {
                case 1:
                    agregarTrabajo(input, trabajoImpresion);
                    break;
                case 2:
                    imprimirPrimerTrabajo(trabajoImpresion);
                    break;
                case 3:
                    imprimirTodo(trabajoImpresion);
                    break;
                case 4:
                    mostrarValores(trabajoImpresion, colaAuxiliar);
                    break;
                case 5:
                    trabajosSegunCantidadPaginas(input, trabajoImpresion, colaAuxiliar);
                    break;
                case 6:
                    System.out.println("Saliendo.....");
                    salir = true;
                    break;
                default:
                    System.out.println("------------\nOpción no válida\n-------------");
                    break;
            }
        } while (!salir);
    }

    public static void agregarTrabajo(Scanner input, ColaCircular<Impresion> trabajoImpresion) {
        String nombre = validaciones.validarTextoIngresado(input, "Nombre del trabajo: ");
        int cantPaginas = validaciones.validarNumero(input, "Cantidad de páginas: ");

        Impresion trabajo = new Impresion(nombre, cantPaginas);
        boolean agregar = trabajoImpresion.offer(trabajo);
        if (!agregar) {
            System.out.println("-----------\nFila llena\n-------------");
        }
    }

    public static void imprimirPrimerTrabajo(ColaCircular<Impresion> trabajoImpresion) {
        if (!trabajoImpresion.isEmpty()) {
            Impresion elemento = trabajoImpresion.remove();
            System.out.println("Se imprimió: " + elemento.toString());
        } else {
            System.out.println("-----------\nNo hay trabajos para imprimir\n-------------");
        }
    }

    public static void imprimirTodo(ColaCircular<Impresion> trabajoImpresion) {
        boolean vaciado = false;
        while (!trabajoImpresion.isEmpty()) {
            Impresion elemento = trabajoImpresion.remove();
            System.out.println("Se imprimió: " + elemento.toString());
            vaciado = true;
        }
        if (!vaciado) {
            System.out.println("-----------\nNo hay trabajos para imprimir\n-------------");

        } else {
            System.out.println("---------\nTrabajos impresos correctamente\n-----------------");
        }

    }

    public static void mostrarValores(ColaCircular<Impresion> trabajoImpresion, ColaCircular<Impresion> colaAux) {
        System.out.println("-------------------");
        if (!trabajoImpresion.isEmpty()) {

            while (!trabajoImpresion.isEmpty()) {
                Impresion elemento = trabajoImpresion.poll();
                if (elemento != null) {
                    System.out.println(elemento.toString());
                    colaAux.add(elemento);
                }
            }
        } else {
            System.out.println("-----------\nNo hay trabajos para mostrar\n-------------");
            return;
        }

        // Devolver los elementos a la cola
        while (!colaAux.isEmpty()) {
            Impresion elemento = colaAux.poll();
            trabajoImpresion.add(elemento);
        }

    }

    public static void trabajosSegunCantidadPaginas(Scanner input, ColaCircular<Impresion> trabajoImpresion,
            ColaCircular<Impresion> colaAux) {
        if (!trabajoImpresion.isEmpty()) {
            int cantPaginasMin = validaciones.validarNumero(input, "Ingrese la cantidad de páginas mínima: ");
            int cant = 0;

            while (!trabajoImpresion.isEmpty()) {
                Impresion trabajo = trabajoImpresion.poll();

                if (trabajo.getCantPagTrabajo() >= cantPaginasMin) {
                    System.out.println(trabajo.toString());
                    cant++;
                }
                colaAux.add(trabajo);
            }
            System.out.println("Cantidad de trabajos con " + cantPaginasMin + " páginas o más: " + cant);
            while (!colaAux.isEmpty()) {
                Impresion trabajo = colaAux.poll();
                trabajoImpresion.add(trabajo);
            }
        } else {
            System.out.println("-----------\nNo hay trabajos para mostrar\n-------------");
            return;
        }
    }
}
