package TP06_Arboles.Punto4;

import java.util.Scanner;

import TP5.Punto1.validaciones;
import utils.BinaryTree.BinarySearchTree;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Estudiante> estudianteTree = new BinarySearchTree<>();

        boolean salir = false;
        do {
            int op = validaciones.validarNumero(input, "Ingrese una opción: ");
            System.out.println("1) Agregar estudiante" + "\n" +
                    "2)Eliminar estudiante");

            switch (op) {
                case 1:
                    agregarEstudiantes(estudianteTree, input);
                    break;

                case 2:
                    eliminarEstudiantePorLu(estudianteTree, input);
                    break;

                case 3:
                    System.out.println(estudianteTree.toString());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (!salir);
    }

    public static void agregarEstudiantes(BinarySearchTree<Estudiante> estudianteTree, Scanner input) {
        System.out.println("------------Nuevo estudiante---------");
        int lu = validaciones.validarNumero(input, "LU: ");
        String apellido = validaciones.validarTextoIngresado(input, "Apellido: ");
        String nombre = validaciones.validarTextoIngresado(input, "Nombre: ");
        String carrera = validaciones.validarTextoIngresado(input, "Carrera: ");
        int añoIngreso = validaciones.validarNumero(input, "Año de ingreso: ");
        System.out.println("---------------------------");

        Estudiante estudiante = new Estudiante(apellido, nombre, lu, carrera, añoIngreso);
        estudianteTree.add(estudiante);
    }

    public static void eliminarEstudiantePorLu(BinarySearchTree<Estudiante> estudianteTree, Scanner input) {
        int luBuscado = validaciones.validarNumero(input, "Lu a buscar: ");
        Estudiante estudiante = new Estudiante("", "", luBuscado, "", 0);
        estudianteTree.remove(estudiante);
    }

}