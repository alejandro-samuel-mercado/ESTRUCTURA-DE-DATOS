package TP3.Punto1;

import utils.validaciones;
import javax.swing.*;

class Main {

    public static void main(String[] args) {
        String[] palabrasInformatica = { "RAM", "CPU", "Disco duro", "Programación", "Bits", "Software", "Hardware",
                "Kernel", "IA", "Web" };
        Stack<String> stack = new Stack<>();
        Stack<String> stackAux = new Stack<>();

        seleccionarAlAzar(palabrasInformatica, stack);
        JOptionPane.showMessageDialog(null,
                "Stack Original: " + "\n" + "----------------------------" + "\n" + mostrar(stack));
        agregarPalabrasAEliminar(stack, stackAux);

    }

    public static void seleccionarAlAzar(String[] palabrasInformatica, Stack<String> stack) {
        while (stack.size() < 5) {
            int random = (int) (Math.random() * palabrasInformatica.length);
            String elemento = palabrasInformatica[random];

            if (!stack.exist(elemento)) {
                stack.push(elemento);
            }
        }
    }

    public static void agregarPalabrasAEliminar(Stack<String> stack, Stack<String> stackAux) {
        int palabrasEliminadas = 0;
        int num = validaciones.validarNumIntEnVentana("Ingrese el número de palabras a eliminar");

        for (int i = 0; i < num; i++) {
            String palabra = JOptionPane.showInputDialog("Ingrese la palabra a eliminar:");

            while (!stack.isEmpty()) {
                String top = stack.pop();
                if (top.equals(palabra)) {
                    palabrasEliminadas++;
                } else {
                    stackAux.push(top);
                }
            }

            while (!stackAux.isEmpty()) {
                stack.push(stackAux.pop());
            }
        }

        JOptionPane.showMessageDialog(null, "Número de palabras eliminadas: " + palabrasEliminadas);

        // Mostrar las palabras restantes en la pila
        if (stack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
        } else {
            JOptionPane.showMessageDialog(null, "Palabras restantes en la pila:\n" + mostrar(stack));
        }
    }

    public static String mostrar(Stack<String> informatica) {
        String mostrar = "";
        for (int i = 0; i < informatica.size(); i++) {
            mostrar += informatica.get(i) + "\n";
        }
        return mostrar;
    }
}