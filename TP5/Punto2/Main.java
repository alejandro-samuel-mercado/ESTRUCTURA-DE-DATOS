package TP5.Punto2;

import java.time.LocalDate;
import java.util.Scanner;

import utils.validaciones;
import utils.List.DoublyLinkedList;
import utils.List.DoublyLinkedLista;
import TP5.Punto2.Alumno;

/**
 * Crear una clase “Lista Doblemente Enlazada” con métodos para insertar
 * elementos en cualquier posición.
 * A partir de esa clase, crear una lista para guardar objetos de la clase
 * Alumno, el cual tiene los siguientes atributos: lu, nombre, dni, fecha de
 * nacimiento, correo electrónico y fecha de ingreso.
 * El programa debe permitir que el usuario elija la posición en donde se
 * inserta el nuevo alumno. Puede ser al principio de la lista, al final o en
 * algún lugar del medio.
 * En esta última opción se puede solicitar al usuario el ingreso de la
 * posición.
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedLista<Alumno> alumnos = new DoublyLinkedLista<>();
        boolean salir = false;
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Agregar alumno al final de la lista");
            System.out.println("1. Agregar alumno al principio de la lista");
            System.out.println("1. Agregar alumno en una ubicación específica");
            System.out.println("4. Mostrar alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");
            opcion = validaciones.validarNumero(input, "");
            switch (opcion) {
                case 1:
                    añadirAlFinal(alumnos, input);
                    break;
                case 2:
                    añadirAlInicio(alumnos, input);
                    break;
                case 3:
                    añadirEnUnaUbicacion(alumnos, input);
                    break;
                case 4:
                    System.out.println(alumnos.toString());
                    break;
                case 5:
                    System.out.println("Saliendo......");
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (!salir);

    }

    public static Alumno añadirAlumno(Scanner input) {
        System.out.println("\n-------------Nuevo alumno----------\n");
        int lu = validaciones.validarNumero(input, "LU: ");
        int dni = validaciones.validarDni(input, "DNI: ");

        String nombre = validaciones.validarTextoIngresado(input, "Nombre: ");
        LocalDate fechaNac = validaciones.validarFormatoFecha(input, "yyyy-MM-dd",
                "Ingrese la fecha de Nacimiento en formato yyyy-MM-dd: ");
        LocalDate fechaIngr = validaciones.validarFormatoFecha(input, "yyyy-MM-dd",
                "Ingrese la fecha de ingreso en formato yyyy-MM-dd: ");
        String correo = validaciones.validarMail(input, "Correo: ");

        Alumno alumno = new Alumno(lu, dni, nombre, fechaNac, fechaIngr, correo);
        return alumno;
    }

    public static void añadirAlFinal(DoublyLinkedLista<Alumno> alumnos, Scanner input) {
        Alumno alumno = añadirAlumno(input);
        alumnos.addLast(alumno);
        System.out.println("--------\nAlumno añadido al final\n---------\n");
    }

    public static void añadirAlInicio(DoublyLinkedLista<Alumno> alumnos, Scanner input) {
        Alumno alumno = añadirAlumno(input);
        alumnos.addFirst(alumno);
        System.out.println("--------\nAlumno añadido al principio\n---------\n");
    }

    public static void añadirEnUnaUbicacion(DoublyLinkedLista<Alumno> alumnos, Scanner input) {
        Alumno alumno = añadirAlumno(input);
        int ubicación = validaciones.validarNumero(input, "---------\nUbicación en la lista: ");
        alumnos.addAtPosition(ubicación, alumno);
        System.out.println("--------\nAlumno añadido en la posición " + ubicación + "\n---------\n");
    }

}
