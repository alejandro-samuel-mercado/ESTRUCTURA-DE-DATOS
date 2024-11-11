package PARCIAL.EjerciciosParcial;

import utils.Stack.*;

public class seven {
    public static void main(String[] args) {
        Stack<Character> pila1 = new Stack<>();
        descomponer(pila1, 23);
    }

    public static void descomponer(Stack<Character> pila, int num) {
        String digito = Integer.toString(num);
        String valor = "";
        for (int i = 0; i < digito.length(); i++) {
            pila.push(digito.charAt(i));
        }

        while (!pila.isEmpty()) {
            valor += pila.pop();
        }
        int nuevoNum = Integer.parseInt(valor);

        System.out.println(nuevoNum);

    }
}
