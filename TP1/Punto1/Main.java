package TP1.Punto1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Uso de try-with-resources para asegurar el cierre del
                                                         // Scanner
            Vehiculo[] vehiculos = new Vehiculo[3];
            // Ingresar datos para 3 vehículos
            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese los datos del vehículo " + (i + 1) + ":");

                System.out.print("Marca: ");
                String marca = validarTextoIngresado(scanner);
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                String tipoMotor = validarMotor(scanner);

                vehiculos[i] = new Vehiculo(marca, modelo, tipoMotor);
            }
            mostrar_vehiculos(vehiculos);
            buscarElementoEnObjeto(scanner, vehiculos);
            contar_naftero_diesel(vehiculos);
        }
    }

    public static String validarMotor(Scanner input) {
        String tipoMotor;
        do {
            System.out.print("Tipo de Motor (diesel/naftero): ");
            tipoMotor = input.nextLine().toLowerCase();
            if (!tipoMotor.equals("diesel") && !tipoMotor.equals("naftero")) {
                System.out.println("Error: Ingrese un tipo de motor válido (diesel o naftero).");
            }
        } while (!tipoMotor.equals("diesel") && !tipoMotor.equals("naftero"));
        return tipoMotor;
    }

    public static void mostrar_vehiculos(Vehiculo vehiculos[]) {
        System.out.println("\nInformación de los vehículos creados:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }

    }

    public static void buscarElementoEnObjeto(Scanner scanner, Vehiculo[] vehiculos) {
        System.out.print("Ingrese el elmento a buscar: ");
        String objetoElegir = scanner.nextLine();
        boolean existeObjeto = false;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equalsIgnoreCase(objetoElegir)) {
                System.out.println(vehiculo.toString());
                existeObjeto = true;
            }
        }
        if (!existeObjeto) {
            System.out.println("No se encontró el elemento");
        }

    }

    public static void contar_naftero_diesel(Vehiculo[] vehiculos) {
        int contadorDiesel = 0;
        int contadorNaftero = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipoMotor().equals("naftero")) {
                contadorNaftero++;
            } else {
                contadorDiesel++;
            }
        }
        System.out.println("Cantidad de motores Diesel: " + contadorDiesel);
        System.out.println("Cantidad de motores Nafteros: " + contadorNaftero);

    }

    /*
     * import java.util.regex.Pattern;
     * import java.util.regex.Matcher;
     */
    public static String validarTextoIngresado(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
            boolean esVacio = validarTextoVacio(input);
            boolean esValido = esSoloCaracteres(input);
            if (esVacio) {
                System.out.println("El campo está vacío.Ingrese un texto válido");
            } else if (!esValido) {
                System.out.println("El texto ingresado no contiene solo caracteres");
                System.out.println("Ingresa nuevamente");
            }

        } while (!esSoloCaracteres(input) || validarTextoVacio(input));
        return input;
    }

    public static boolean esSoloCaracteres(String texto) {
        String alfb = "^[a-zA-Z(\s]+$";
        Pattern pattern = Pattern.compile(alfb);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    public static boolean validarTextoVacio(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return false;

    }

}
