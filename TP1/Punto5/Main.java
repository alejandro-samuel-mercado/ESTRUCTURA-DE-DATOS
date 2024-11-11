package TP1.Punto5;

import java.util.ArrayList;
import java.util.Scanner;
import utils.validaciones;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<SerieTV> series = new ArrayList<>();
            opciones(input, series);
        }
    }

    public static void opciones(Scanner input, ArrayList<SerieTV> series) {
        String op;
        boolean salir = false;
        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1: Agregar series");
            System.out.println("2:Mostrar todas las series");
            System.out.println("3: Buscar una serie ");
            System.out.println("4: Mostrar las series dispoibles");
            System.out.println("5: Salir");
            op = input.nextLine();
            switch (op) {
                case "1":
                    series = ingresarDatos(input, series);
                    break;
                case "2":
                    if (series.size() != 0) {
                        mostrarTodas(series);
                    } else {
                        System.out.println("No hay series en la lista");
                    }
                    break;

                case "4":
                    if (series.size() != 0) {
                        mostrarDisponibles(series);
                    } else {
                        System.out.println("No hay series en la lista");
                    }
                    break;
                case "3":
                    if (series.size() != 0) {
                        buscarSerie(series, input);
                    } else {
                        System.out.println("No hay series en la lista");
                    }
                    break;

                case "5":
                    salir = true;

            }

        } while (!salir);

    }

    public static ArrayList<SerieTV> ingresarDatos(Scanner input, ArrayList<SerieTV> series) {

        String continuar = "";

        do {
            String titulo = validaciones.validarTextoIngresado(input, "Ingrese el título de la serie: ");
            String director = validaciones.validarTextoIngresado(input, "Ingrese el director de la serie: ");
            int año = validaciones.validarNumero(input, "Ingrese el año de la serie: ");
            int duracion = validaciones.validarNumero(input, "Ingrese la duración de la serie (en minutos): ");

            System.out.print("¿Está disponible la serie? (true/false): ");
            boolean disponible = input.nextBoolean();
            input.nextLine(); // Limpiar el buffer del scanner

            int temporadas = validaciones.validarNumero(input, "Ingrese el número de temporadas: ");
            String genero = validaciones.validarTextoIngresado(input, "Ingrese el género de la serie: ");

            SerieTV serie = new SerieTV(titulo, director, año, duracion, disponible, temporadas, genero);
            series.add(serie);
            System.out.print("¿Desea agregar otra serie? (sí/no): ");
            continuar = input.nextLine().toLowerCase();
        } while (continuar.equalsIgnoreCase("si"));

        return series;
    }

    public static void buscarSerie(ArrayList<SerieTV> series, Scanner input) {
        boolean encontrada = false;
        String serieABuscar = validaciones.validarTextoIngresado(input, "Serie a buscar: ");
        for (SerieTV serie : series) {
            if (serie.getTitulo().equals(serieABuscar)) {
                serie.mostrarDatos();
                encontrada = true;
                break;
            }

        }
        if (!encontrada) {
            System.out.println("Serie no encontrada");
        }

    }

    public static void mostrarTodas(ArrayList<SerieTV> series) {
        int numSerie = 1;
        for (SerieTV serie : series) {
            System.out.println("Serie " + numSerie + ": ");
            serie.mostrarDatos();
            System.out.println("---------------------------------------");
            numSerie++;
        }
    }

    public static void mostrarDisponibles(ArrayList<SerieTV> series) {
        for (SerieTV serie : series) {
            if (serie.getIsDisponible()) {
                serie.mostrarDatos();
                System.out.println("---------------------------------------");
            }

        }
    }

}