package TP0;

import java.util.Scanner;

public class Punto4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int aleatorio = generar_aleatorio();
        verificar_validez(scanner, aleatorio);
        scanner.close();
    }

    public static int generar_aleatorio() {
        int aleatorio = 1 + (int) (Math.random() * 100); // Da un valor entre 0 y 100
        return aleatorio;
    }

    public static void verificar_validez(Scanner scanner, int aleatorio) {
        int input;
        int intentos = 0;
        do {
            System.out.println("Ingrese un N°: ");
            input = Integer.parseInt(scanner.nextLine());
            if (input < aleatorio) {
                System.out.println("El valor es mayor al ingresado");

            } else if (input > aleatorio) {
                System.out.println("El valor es menor al ingresado");
            }
            intentos++;

        } while (input != aleatorio);
        System.out.println("Correcto");
        System.out.println("N° de intentos: " + intentos);
    }

}
