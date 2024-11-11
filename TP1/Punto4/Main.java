package TP1.Punto4;

import java.util.Scanner;

import utils.validaciones;

/**
 * main
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Herramienta[] herramientas = new Herramienta[3];
            // Ingresar datos para 3 vehículos
            for (int i = 0; i < herramientas.length; i++) {
                System.out.println("Ingrese los datos de la herramienta " + (i + 1) + ":");

                int codigo = validaciones.validarNumero(scanner, "Código: ");
                String nombre = validaciones.validarTextoIngresado(scanner, "Nombre: ");
                String tipo = validaciones.validarTextoIngresado(scanner, "Tipo: ");
                double precio = validaciones.validarNumero(scanner, "Precio: ");
                int cantidad = validaciones.validarNumero(scanner, "Cantidad: ");

                herramientas[i] = new Herramienta(codigo, nombre, cantidad, precio, tipo);
            }
            opciones(scanner, herramientas);
        }

    }

    public static void opciones(Scanner input, Herramienta[] herramientas) {
        String op;
        boolean salir = false;
        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1: Calcular valor total de herramientas");
            System.out.println("2: Entregar cantidad de una herramienta");
            System.out.println("3: Mostrar información específica de una herramientaa");
            System.out.println("4: Mostrar toda la información de las herramientas");
            System.out.println("5: Salir");
            op = input.nextLine();
            switch (op) {
                case "1":
                    int num = 1;
                    for (Herramienta herramienta : herramientas) {
                        System.out.println("Valor total de herramienta" + num + ": " + herramienta.calcularValor());
                        num++;
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el número de la herramienta a buscar: ");
                    int herramientaABuscar = input.nextInt();
                    input.nextLine();
                    if (herramientaABuscar > 0 && herramientaABuscar <= herramientas.length) {
                        herramientas[herramientaABuscar - 1].entregarCantidad(input);
                    } else {
                        System.out.println("Número de herramienta inválido.");
                    }
                    break;
                case "3":
                    System.out.println("Tipo de herramienta a buscar: ");
                    String tipoABuscar = input.nextLine();
                    for (Herramienta herramienta : herramientas) {
                        System.out.println(herramienta.mostrarInfoEspecifica(input, tipoABuscar));
                    }
                    break;
                case "4":
                    for (Herramienta herramienta : herramientas) {
                        System.out.println(herramienta.toString());
                    }

                case "5":
                    salir = true;

            }

        } while (!salir);

    }
}