package TP3.Punto5;

import TP3.Punto1.Stack;
import utils.validaciones;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Stack<String> deshacer = new Stack<>();
        Stack<String> rehacer = new Stack<>();
        Stack<String> aux = new Stack<>();
        String[] acciones = { "negrita", "cursiva", "insertar tabla", "subrayado", "insertar imagen", "escribir texto",
                "borrar texto" };
        cargarAccionesRandom(acciones, deshacer);
        menu(deshacer, rehacer, aux);
    }

    public static void menu(Stack<String> deshacer, Stack<String> rehacer, Stack<String> aux) {
        boolean salir = false;

        do {
            int opcion = validaciones.validarNumIntEnVentana("INGRESE UNA OPCION" + "\n" + "------------" + "\n" +
                    "1-Deshacer" + "\n" +
                    "2-Rehacer" + "\n" +
                    "3-Mostrar" + "\n" +
                    "4-Salir");

            switch (opcion) {
                case 1:
                    deshacerAccion(deshacer, rehacer);
                    break;
                case 2:
                    rehacerAccion(deshacer, rehacer);
                    break;
                case 3:
                    mostrarAccionesADeshacer(deshacer, aux);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }

        } while (!salir);
    }

    public static void cargarAccionesRandom(String[] acciones, Stack<String> deshacer) {
        int cont = 0;

        while (acciones.length >= cont) {
            int indxRandom = (int) (Math.random() * acciones.length);
            deshacer.push(acciones[indxRandom]);
            cont++;
        }

    }

    public static void mostrarAccionesADeshacer(Stack<String> deshacer, Stack<String> aux) {
        String mostrar = "";
        while (!deshacer.isEmpty()) {
            String elemento = deshacer.pop();
            aux.push(elemento);
        }
        for (int i = 0; i < aux.size(); i++) {
            mostrar += aux.get(i) + "\n";
        }

        while (!aux.isEmpty()) {
            String elemento = aux.pop();
            deshacer.push(elemento);
        }

        JOptionPane.showMessageDialog(null, "Acciones" + "\n--------\n" + mostrar);

    }

    public static void deshacerAccion(Stack<String> deshacer, Stack<String> rehacer) {
        String elemento = deshacer.pop();
        rehacer.push(elemento);

    }

    public static void rehacerAccion(Stack<String> deshacer, Stack<String> rehacer) {
        int numARehacer;
        do {
            numARehacer = validaciones.validarNumIntEnVentana("Número de operaciones a rehacer");
            if (numARehacer > rehacer.size()) {
                JOptionPane.showMessageDialog(null, "El Nº ingresado supera la cantidad de acciones realizadas ");

            }
        } while (numARehacer > rehacer.size());

        if (!rehacer.isEmpty()) {
            for (int i = 0; i < numARehacer; i++) {
                String elemento = rehacer.pop();
                deshacer.push(elemento);
            }

        }

    }

}