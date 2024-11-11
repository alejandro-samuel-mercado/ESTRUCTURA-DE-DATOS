package TP5.Punto1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Implementar una clase “ListaEnlazadaSimple” que permita insertar, eliminar,
 * buscar y mostrar elementos.
 * Comprobar el correcto funcionamiento de la implementación propuesta creando
 * una instancia de la lista.
 * Se deben guardar X cantidad de objetos de la clase Empleado, la cual posee un
 * legajo, dni, nombre, fecha de nacimiento y correo electrónico. Realizar las
 * operaciones a pedido del usuario. Para ello, se deberá utilizar un menú de
 * opciones.
 **/
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SingleLinkedList<Empleado> empleados = new SingleLinkedList<Empleado>();
        int opcion;
        boolean salir = false;
        do {
            System.out.println("\n--- Menú Gestión---");
            System.out.println("1. Agregar empleado a la lista");
            System.out.println("2. Eliminar un empleado");
            System.out.println("3. Buscar un empleado");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción:\n---------------------\n ");
            opcion = validaciones.validarNumero(input, "");
            switch (opcion) {
                case 1:
                    agregarEmpleado(input, empleados);
                    break;
                case 2:
                    eliminarEmpleado(input, empleados);
                    break;
                case 3:
                    System.out.println(buscarEmpledo(input, empleados));
                    break;
                case 4:
                    empleados.mostrar();
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

    public static void agregarEmpleado(Scanner input, SingleLinkedList<Empleado> empleados) {
        System.out.println("----------------------------------\nEmpleado a agregar\n--------");
        int legajo = validaciones.validarNumero(input, "Legajo: ");
        int dni = validaciones.validarDni(input, "Dni: ");
        String nombre = validaciones.validarTextoIngresado(input, "Nombre: ");
        LocalDate fecha = validaciones.validarFormatoFecha(input, "yyyy-MM-dd", "Fecha de nacimiento: ");
        String correo = validaciones.validarMail(input, "Correo: ");

        Empleado empleado = new Empleado(legajo, dni, nombre, fecha, correo, 12);
        empleados.addLast(empleado);
    }

    public static void eliminarEmpleado(Scanner input, SingleLinkedList<Empleado> empleados) {
        int dniAEliminar = validaciones.validarNumero(input,
                "-----------------\nDNI del empleado a eliminar: ");
        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getDni() == dniAEliminar) {
                empleados.remove(empleado);
                encontrado = true;
                System.out.println("-----\nEliminado!");
                break;

            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado");
        }
    }

    public static String buscarEmpledo(Scanner input, SingleLinkedList<Empleado> empleados) {
        int dniABuscar = validaciones.validarNumero(input, "DNI del empleado a buscar: ");

        for (Empleado empleado : empleados) {
            if (empleado.getDni() == dniABuscar) {
                return empleado.toString();
            }
        }
        return "--------Empleado no encontrado--------";
    }
}
