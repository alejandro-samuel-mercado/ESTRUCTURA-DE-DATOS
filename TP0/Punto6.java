package TP0;

import java.util.Scanner;

public class Punto6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = scanner.nextLine().toLowerCase();
        System.out.println("Ingreses una letra");
        String letra_ = scanner.nextLine();
        char letra = letra_.charAt(0);
        int cantidad = contar_caracteres(frase, letra);
        System.out.println("Cantidad de veces que aparece la letra " + letra + ": " + cantidad);
        scanner.close();
    }

    public static int contar_caracteres(String frase, char letra) {
        int cantidad = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                cantidad++;
            }
        }

        return cantidad;
    }
}
