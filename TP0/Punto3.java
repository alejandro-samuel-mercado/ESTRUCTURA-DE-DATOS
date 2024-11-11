package TP0;

import java.util.Scanner;

public class Punto3 {

    public static void main(String[] args) {
        Boolean inOperation = true;
        float saldo = 0;
        Scanner scanner = new Scanner(System.in);

        while (inOperation) {
            System.out.println("Ingrese una opción: ");
            String opcion = scanner.nextLine();
            saldo = operacion(opcion, saldo, scanner);
            if (opcion.equals("d")) {
                inOperation = false;
            }
        }
        scanner.close();
    }

    public static float operacion(String opcion, float saldo, Scanner scanner) {
        switch (opcion) {
            case "a":
                System.out.println("Saldo actual: " + saldo);
                break;

            case "b":
                System.out.println("Ingrese dinero a depositar: ");
                float depositar = Float.parseFloat(scanner.nextLine());
                saldo += depositar;
                break;
            case "c":
                System.out.println("Ingrese dinero a retirar: ");
                float retirar = Float.parseFloat(scanner.nextLine());
                if (saldo >= retirar) {
                    saldo -= retirar;
                } else {
                    System.out.println("Saldo insuficiente");
                }

                break;
            case "d":
                System.out.println("Saliendo.....");
                break;

            default:
                break;

        }
        return saldo;

    }

}