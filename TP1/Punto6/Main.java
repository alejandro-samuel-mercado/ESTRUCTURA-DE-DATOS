package TP1.Punto6;

import java.util.Scanner;

import utils.validaciones;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ErjecicioGrupal> grupales = new ArrayList<>();
        ArrayList<EntrenamientoPersonalizado> personalizados = new ArrayList<>();

        opciones(input, grupales, personalizados);

    }

    public static void opciones(Scanner input, ArrayList<ErjecicioGrupal> grupales,
            ArrayList<EntrenamientoPersonalizado> personalizados) {
        String op;
        boolean salir = false;
        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1: Ejercicio grupal");
            System.out.println("2: Entrenamiento personalizado");
            System.out.println("3: Salir");
            op = input.nextLine();

            switch (op) {
                case "1":
                    ejercicioGrupal(input, grupales);
                    break;
                case "2":
                    ejercicioPersonalizado(input, personalizados);
                    break;

                case "3":
                    salir = true;

            }

        } while (!salir);

    }

    public static void ejercicioGrupal(Scanner input, ArrayList<ErjecicioGrupal> grupales) {
        String op;
        boolean salir = false;
        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1: Agregar un ejercicio grupal");
            System.out.println("2: Mostrar ejercicios grupales");
            System.out.println("3: Salir");
            op = input.nextLine();

            switch (op) {
                case "1":
                    agregarEjercicioGrupal(input, grupales);
                    break;
                case "2":
                    for (ErjecicioGrupal grupal : grupales) {
                        grupal.mostarEjecricioGrupal();
                    }
                    break;

                case "3":
                    salir = true;

            }

        } while (!salir);

    }

    public static void ejercicioPersonalizado(Scanner input, ArrayList<EntrenamientoPersonalizado> personalizados) {
        String op;
        boolean salir = false;
        do {
            System.out.println("Ingrese una opción: ");
            System.out.println("1: Agregar un ejercicio personalizado");
            System.out.println("2: Mostrar ejercicios personalizados");
            System.out.println("3: Salir");
            op = input.nextLine();

            switch (op) {
                case "1":
                    agregarEjercicioPersonalizado(input, personalizados);
                    break;
                case "2":
                    for (EntrenamientoPersonalizado p : personalizados) {
                        System.out.println(" ");
                        p.mostarEntrenamiento();
                    }
                    break;

                case "3":
                    salir = true;

            }

        } while (!salir);

    }

    public static ArrayList<ErjecicioGrupal> agregarEjercicioGrupal(Scanner input,
            ArrayList<ErjecicioGrupal> grupales) {
        String continuar = "";
        do {
            String nombreCentroEntrenamiento = validaciones.validarTextoIngresado(input,
                    "Ingrese el nombre del entrenamiento ");
            String nombreActividadFisica = validaciones.validarTextoIngresado(input,
                    "Ingrese el nombre de la actividad: ");
            String instructor = validaciones.validarTextoIngresado(input, "Ingrese el nombre del instructor: ");

            System.out.print("Disponibilidad: ");
            boolean disponible = input.nextBoolean();
            input.nextLine(); // Limpiar el buffer del scanner
            String diaSemana = validaciones.validarTextoIngresado(input, "Ingrese el día de la semana ");
            int horaInicio = validaciones.validarNumero(input, "Hora de inicio: ");

            String nivelDificultad = validaciones.validarTextoIngresado(input, "Ingrese el nivel de dificultad: ");
            int cantidadParticipantes = validaciones.validarNumero(input, "Ingrese la cantidad de participantes:  ");
            int diaFinalizacion = validaciones.validarNumero(input, "Ingrese el día de finalización:  ");

            ErjecicioGrupal grupal = new ErjecicioGrupal(nombreCentroEntrenamiento, nombreActividadFisica, instructor,
                    disponible, diaSemana,
                    horaInicio, nivelDificultad, cantidadParticipantes, diaFinalizacion);
            grupales.add(grupal);
            System.out.print("¿Desea agregar más? (sí/no): ");
            continuar = input.nextLine().toLowerCase();
        } while (continuar.equalsIgnoreCase("si"));

        return grupales;

    }

    public static ArrayList<EntrenamientoPersonalizado> agregarEjercicioPersonalizado(Scanner input,
            ArrayList<EntrenamientoPersonalizado> p) {
        String continuar = "";

        do {
            String nombreCentroEntrenamiento = validaciones.validarTextoIngresado(input,
                    "Ingrese el nombre del entrenamiento ");
            String nombreActividadFisica = validaciones.validarTextoIngresado(input,
                    "Ingrese el nombre de la actividad: ");

            String instructor = validaciones.validarTextoIngresado(input, "Ingrese el nombre del instructor: ");

            System.out.print("Disponibilidad: ");
            boolean disponible = input.nextBoolean();
            input.nextLine(); // Limpiar el buffer del scanner
            String diaSemana = validaciones.validarTextoIngresado(input, "Ingrese el día de la semana: ");
            int horaInicio = validaciones.validarNumero(input, "Hora de inicio: ");
            /*
             * private int duracionHoras;
             * private String objetivosEntrenamiento;
             * private String rutinaPersonalizada;
             */
            int duracionHoras = validaciones.validarNumero(input, "Ingrese la duración de horas: ");
            String objetivosEntrenamiento = validaciones.validarTextoIngresado(input,
                    "Ingrese los objetivos del entrenamiento:  ");
            String rutinaPersonalizada = validaciones.validarTextoIngresado(input, "Ingrese la rutina personaliada:  ");

            EntrenamientoPersonalizado personalizado = new EntrenamientoPersonalizado(nombreCentroEntrenamiento,
                    nombreActividadFisica, instructor, disponible, diaSemana, horaInicio, duracionHoras,
                    objetivosEntrenamiento,
                    rutinaPersonalizada);
            p.add(personalizado);
            System.out.print("¿Desea agregar más? (sí/no): ");
            continuar = input.nextLine().toLowerCase();
        } while (continuar.equalsIgnoreCase("si"));

        return p;

    }
}
