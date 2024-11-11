package TP0;

/**
 * main
 */

import java.util.Scanner;

public class Punto1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            System.out.println("Vacío, ingrese algun valor");
        } while (input.equals(" "));

        scanner.close();
        mostrar_en_mayusculas(input);
        mostrar_en_minusculas(input);
        contar_mayusculas_minusculas(input);

    }

    public static void mostrar_en_mayusculas(String input) {
        String mayus_result = input.toUpperCase();
        System.out.println("En mayusculas: " + mayus_result);
    }

    public static void mostrar_en_minusculas(String input) {
        String menor_result = input.toLowerCase();
        System.out.println("En minusculas: " + menor_result);
    }

    public static void contar_mayusculas_minusculas(String input) {
        int contador1 = 0;
        int contador2 = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                contador1++;
            }
            if (Character.isLowerCase(input.charAt(i))) {
                contador2++;
            }
        }
        System.out.println("Cantidad de mayusculas: " + contador1);
        System.out.println("Cantidad de minusculas: " + contador2);
    }

    /*
     * public static int contar_minusculas(String input) {
     * int contador = 0;
     * for (int i = 0; i < input.length(); i++) {
     * if (Character.isLowerCase(input.charAt(i))) {
     * contador++;
     * }
     * }
     * return contador;
     * }
     */

}