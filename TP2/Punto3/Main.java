package TP2.Punto3;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import utils.validaciones;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        añadirNum(lista);
        mostrarArray(lista);
        encontrarMax(lista);
        encontrarMin(lista);
    }

    public static void añadirNum(ArrayList<Integer> lista) {
        int tamaño = validaciones.validarNumIntEnVentana("Tamaño del array");
        for (int i = 0; i < tamaño; i++) {
            int num = (int) (Math.random() * 100);
            lista.add(num);
        }
    }

    public static void mostrarArray(ArrayList<Integer> lista) {
        String string = "";
        for (int i = 0; i < lista.size(); i++) {
            string += lista.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, string, "El maximo valor del array es:", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void encontrarMax(ArrayList<Integer> lista) {
        int max = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            int elemento = lista.get(i);
            if (elemento > max) {
                max = elemento;
            }
        }
        JOptionPane.showMessageDialog(null, max, "El maximo valor del array es:", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void encontrarMin(ArrayList<Integer> lista) {
        int min = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            int elemento = lista.get(i);
            if (elemento < min) {
                min = elemento;
            }
        }
        JOptionPane.showMessageDialog(null, min, "El maximo valor del array es:", JOptionPane.INFORMATION_MESSAGE);
    }
}
