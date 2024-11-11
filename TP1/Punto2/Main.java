package TP1.Punto2;

import java.util.Scanner;
import utils.validaciones;

public class Main {
    public static void main(String[] args) {
        ArticuloDeLibreria articulo = new ArticuloDeLibreria();
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;
        cargarDatos(scanner, articulo);
        while (salir) {
            salir = opciones(scanner, articulo, salir, articulo.getCantidad());
        }
    }

    /**
     * VBHRBRBFKRKGB
     * 
     * @param scanner  hbbhjbhhjb
     * @param articulo hbjbjhbjhbjh
     * @throws
     */
    public static void cargarDatos(Scanner scanner, ArticuloDeLibreria articulo) {
        int codigo = validaciones.validarNumero(scanner, "Ingrese un código: ");
        String nombre = validaciones.validarTextoIngresado(scanner, "Ingrese un nombre: ");
        System.out.println("Ingrese un precio");
        float precio = scanner.nextFloat();
        scanner.nextLine();

        int cantidad = validaciones.validarNumero(scanner, "Ingrese una cantidad: ");

        articulo.setCodigo(codigo);
        articulo.setNombre(nombre);
        articulo.setPrecio(precio);
        articulo.setCantidad(cantidad);

    }

    public static boolean opciones(Scanner scanner, ArticuloDeLibreria articulo, boolean salir, int cantidad) {
        System.out.println("Eliga un opcion");
        String op = scanner.nextLine();

        switch (op) {
            case "1":
                System.out.println("Cantidad a depositar: ");
                cantidad = scanner.nextInt();
                scanner.nextLine();
                articulo.depositarEnStock(cantidad);
                break;
            case "2":

                cantidad = articulo.retirarDeStock(scanner);
                break;
            case "3":
                String datos = articulo.toStringg();
                System.out.println(datos);
                break;
            case "4":
                return false;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
        return true;
    }

}
