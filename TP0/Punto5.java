package TP0;

import java.util.Scanner;
import java.util.Random;

public class Punto5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        input_password(scanner, random);
        ;
    }

    public static void input_password(Scanner scanner, Random random) {
        System.out.println("Longitud de la contraseña:  ");
        int longitud = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        System.out.println("¿Desea incluir mayúsculas? (S/N): ");
        boolean incluirMayusculas = scanner.nextLine().equalsIgnoreCase("S");

        System.out.println("¿Desea incluir minúsculas? (S/N): ");
        boolean incluirMinusculas = scanner.nextLine().equalsIgnoreCase("S");

        System.out.println("¿Desea incluir números? (S/N): ");
        boolean incluirNumeros = scanner.nextLine().equalsIgnoreCase("S");

        System.out.println("¿Desea incluir caracteres especiales? (S/N): ");
        boolean incluirEspeciales = scanner.nextLine().equalsIgnoreCase("S");

        String password = generar_password(longitud, incluirMayusculas, incluirMinusculas, incluirNumeros,
                incluirEspeciales, random);
        System.out.println("Contraseña: " + password);
    }

    public static String generar_password(int longitud, boolean incluirMayusculas, boolean incluirMinusculas,
            boolean incluirNumeros, boolean incluirEspeciales, Random random) {

        String password = "";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiales = "@#$%&*-_+ñ.";

        while (password.length() < longitud) {
            int caso = 1 + random.nextInt(4); // Genera un número entre 1 y 4
            int index;
            switch (caso) {
                case 1:
                    if (incluirMayusculas) {
                        index = random.nextInt(mayusculas.length());
                        password += mayusculas.charAt(index);
                    }
                    break;
                case 2:
                    if (incluirMinusculas) {
                        index = random.nextInt(minusculas.length());
                        password += minusculas.charAt(index);
                    }
                    break;
                case 3:
                    if (incluirNumeros) {
                        index = random.nextInt(numeros.length());
                        password += numeros.charAt(index);
                    }
                    break;
                case 4:
                    if (incluirEspeciales) {
                        index = random.nextInt(especiales.length());
                        password += especiales.charAt(index);
                    }
                    break;
                default:
                    break;
            }
        }

        return password.toString();
    }
}
