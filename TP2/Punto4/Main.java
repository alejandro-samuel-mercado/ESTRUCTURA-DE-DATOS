package TP2.Punto4;

import utils.validaciones;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        agregarElementos(lista);
        verificarDuplicados(lista);

    }

    public static void agregarElementos(ArrayList<Integer> lista) {
        int tamaño = 10;
        JOptionPane.showMessageDialog(null, "Añada diez números");

        for (int i = 0; i < tamaño; i++) {
            int num = validaciones.validarNumIntEnVentana("Número " + (i + 1));
            lista.add(num);
        }

    }

    public static void verificarDuplicados(ArrayList<Integer> lista) {
        ArrayList<Integer> numDuplicados = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j)) && !(numDuplicados.contains(lista.get(i)))) {
                    numDuplicados.add(lista.get(i));
                    break;
                }
            }
        }
        mostrarDuplicados(numDuplicados);
    }

    public static void mostrarDuplicados(ArrayList<Integer> numDuplicados) {
        String numeros = "";
        for (Integer num : numDuplicados) {
            numeros += num + ", ";
        }
        JOptionPane.showMessageDialog(null, "Números repetidos: " + numeros);

    }
}
