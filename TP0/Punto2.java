package TP0;

import java.util.Scanner;

public class Punto2 {

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese el capital inicial: ");
                float capital_inicial = Float.parseFloat(scanner.nextLine());
                System.out.println("Ingrese la tasa de interes anual");
                float tasa_anual = Float.parseFloat(scanner.nextLine());
                System.out.println("Años trabajados");
                int años = Integer.parseInt(scanner.nextLine());

                scanner.close();

                float monto_acumulado = calcular(capital_inicial, tasa_anual, años);
                System.out.println("Monto acumulado: " + monto_acumulado);

            } catch (Exception e) {
                System.out.println("Error, el valor ingresado no es un N°" + e);
            }
        }

    }

    public static float calcular(float capital, float tasa, int años) {
        float monto_acumulado = capital * (float) Math.pow(1 + (tasa / 100), años);
        return monto_acumulado;
    }

}
