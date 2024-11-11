package TP1.Punto3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import utils.validaciones;

public class Main {
    static String nombre;
    static String descripcion;
    static LocalDate fechaInicio;
    static LocalDate fechaFinal;
    static Evento evento;
    static LocalDate fechaActual = LocalDate.now();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ingresarDatos(input);
        boolean esValido = validarFechas(fechaInicio, fechaFinal);
        if (esValido) {
            evento = new Evento(nombre, descripcion, fechaInicio, fechaFinal);
        } else {
            evento = new Evento();
        }
        menuOpciones(input, evento);

    }

    public static void ingresarDatos(Scanner input) {
        nombre = validaciones.validarTextoIngresado(input, "Ingrese nombre del evento: ");
        descripcion = validaciones.validarTextoIngresado(input, "Ingrese una descripción: ");
        String mensaje1 = "Ingrese una fecha de inicio con el formato \"yyyy-MM-dd\"";
        String mensaje2 = "Ingrese una fecha final con el formato \"yyyy-MM-dd\"";
        fechaInicio = leerFechaCorrecta(input, mensaje1);
        fechaFinal = leerFechaCorrecta(input, mensaje2);

    }

    public static LocalDate leerFechaCorrecta(Scanner scanner, String mensaje) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = null;

        while (fecha == null) {
            System.out.println(mensaje);
            String input = scanner.nextLine();
            try {
                fecha = LocalDate.parse(input, formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, ingresa la fecha en el formato yyyy-MM-dd.");
            }
        }

        return fecha;
    }

    public static boolean validarFechas(LocalDate fechaInicio, LocalDate fechaFinal) {
        boolean esValida = false;
        if (fechaInicio.isBefore(fechaFinal)) {
            if ((fechaFinal.getDayOfYear() - fechaInicio.getDayOfYear()) <= 30) {
                esValida = true;
            }
        }
        return esValida;
    }

    public static void menuOpciones(Scanner scanner, Evento evento) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Ingrese una opción: 1/2/3/4/5/6");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println(evento.mostrarInfo());
                    break;
                case "2":
                    calcular_dias_duracion(evento);
                    break;
                case "3":
                    determinar_curso_evento(evento);
                    break;
                case "4":
                    diasRestantesParaEvento(fechaActual, evento);
                    break;
                case "5":
                    diasTranscurridosDesdeEvento(fechaActual, evento);
                    break;
                case "6":
                    salir = true;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        }

    }

    // Calcular la duración del evento en días.
    public static void calcular_dias_duracion(Evento evento) {
        int duracion = evento.getFechaFinal().getDayOfMonth() - evento.getFechaInicio().getDayOfMonth();
        System.out.println("Duración del evento: " + duracion + " días");
    }

    // Determinar si el evento está en curso en la fecha actual.
    public static void determinar_curso_evento(Evento evento) {
        LocalDate fecha_actual = LocalDate.now();
        if ((evento.getFechaFinal().isEqual(fecha_actual) || evento.getFechaFinal().isAfter(fecha_actual)) &&
                (evento.getFechaInicio().isEqual(fecha_actual) || evento.getFechaInicio().isBefore(fecha_actual))) {
            System.out.println("El evento está en curso en la fecha actual");
        } else if (evento.getFechaFinal().isBefore(fecha_actual)) {
            System.out.println("El evento ya ha finalizado");
        } else {
            System.out.println("El evento aún no ha comenzado");
        }
    }

    // Calcular la cantidad de días restantes hasta el inicio del evento.
    public static void diasRestantesParaEvento(LocalDate fechaActual, Evento evento) {
        if (evento.getFechaInicio().isAfter(fechaActual)) {
            int dias_restantes = evento.getFechaInicio().getDayOfYear() - fechaActual.getDayOfYear();
            System.out.println("Días restantes hasta el inicio del evento: " + dias_restantes + " días");
        } else {
            System.out.println("El evento ya terminó");
        }
    }

    public static void diasTranscurridosDesdeEvento(LocalDate fechaActual, Evento evento) {
        if (evento.getFechaInicio().isBefore(fechaActual)) {
            int dias_transcurridos = fechaActual.getDayOfYear() - evento.getFechaInicio().getDayOfYear();
            System.out.println("Días restantes hasta el inicio del evento: " + dias_transcurridos + " días");
        } else {
            System.out.println("El evento aún no empezó");
        }

    }

}