package TP3.Punto2;

import utils.validaciones;
import TP3.Stack;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackAux = new Stack<>();
        String num = ingresarNumCuatroCifras();
        descomponerYCargarPila(stack, num);
        numeroAlreves(stack, stackAux);
        mostrarParesEImpares(stackAux);
    }

    public static String ingresarNumCuatroCifras() {
        boolean esValido;
        int num;
        do {
            num = validaciones.validarNumIntEnVentana("Ingrese un número entero");
            esValido = tieneNCifras(num, 4);

        } while (!esValido);

        return Integer.toString(num);
    }

    public static boolean tieneNCifras(int elemento, int cantCifras) {
        String convertir = Integer.toString(Math.abs(elemento));
        boolean tieneNCifras = false;
        if (convertir.length() != 4) {
            JOptionPane.showMessageDialog(null, "El número debe tener" + cantCifras + " cifras");
        } else {
            tieneNCifras = true;
        }
        return tieneNCifras;
    }

    public static void descomponerYCargarPila(Stack<Character> stack, String num) {
        String valores = "";
        for (int i = 0; i < num.length(); i++) {
            stack.push(num.charAt(i));
            valores += num.charAt(i) + " ";
        }
        JOptionPane.showMessageDialog(null, "Original:" + "\n" + valores);
    }

    public static void numeroAlreves(Stack<Character> stack, Stack<Character> stackAux) {

        String numAlreves = "";

        while (!stack.isEmpty()) {
            char element = stack.pop();
            stackAux.push(element); // Carga el stack auxuliar con los valores del original
            numAlreves += element + " ";
        }

        JOptionPane.showMessageDialog(null, "Número al revés:" + "\n" + numAlreves);
    }

    public static void mostrarParesEImpares(Stack<Character> stackAux) {
        String pares = "";
        String impares = "";
        while (!stackAux.isEmpty()) {
            char element = stackAux.pop();
            if (element % 2 == 0) {
                pares += element + " ";
            } else {
                impares += element + " ";
            }
        }

        JOptionPane.showMessageDialog(null, "Pares" + "\n" + pares);
        JOptionPane.showMessageDialog(null, "Impares" + "\n" + impares);

    }

}
