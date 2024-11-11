package TP2.Punto6;

import javax.swing.JOptionPane;

public class Matriz {
    private int[][] matriz;
    private int m;
    private int n;

    public Matriz(int m, int n) {
        this.m = m;
        this.n = n;
        matriz = new int[m][n];
    }

    public void llenarMatriz() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public void mostrarMatriz() {
        String mostrarMatriz = "";
        for (int[] fila : matriz) {
            for (int e : fila) {
                mostrarMatriz += e + "  ";
            }
            mostrarMatriz += "\n";
        }

        JOptionPane.showMessageDialog(null, mostrarMatriz);
    }

    public void buscarElemento(int elemento) {
        int indice1 = -1;
        int indice2 = -1;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (matriz[i][j] == elemento) {
                    indice1 = i;
                    indice2 = j;
                    break;
                }
            }
        }
        if (indice1 != -1 || indice2 != -1) {
            JOptionPane.showMessageDialog(null,
                    "Elemento encontrado en la posición " + "[" + indice1 + "]" + "[" + indice2 + "]");

        } else {
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");

        }
    }

    public void mostrarNumIzqDerecha(int fila, int columna, String direccion) {
        if (fila < 0 || fila >= m || columna < 0 || columna >= n) {
            JOptionPane.showMessageDialog(null, "Posición fuera de los límites de la matriz");
            return;
        }

        // int elemento = matriz[fila][columna];
        String numeros = "";

        ////////////////////
        if (direccion.equalsIgnoreCase("izquierda")) {
            if (columna == 0) {
                JOptionPane.showMessageDialog(null, "No hay números a la izquierda de la posición indicada");
                return;
            }
            for (int j = columna - 1; j >= 0; j--) {
                numeros += matriz[fila][j] + "   ";
            }
        } else if (direccion.equalsIgnoreCase("derecha")) {
            if (columna == n - 1) {
                JOptionPane.showMessageDialog(null, "No hay números a la derecha de la posición indicada");
                return;
            }
            for (int j = columna + 1; j < n; j++) {
                numeros += matriz[fila][j] + "   ";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dirección no válida. Use 'izquierda' o 'derecha'.");
            return;

        }
        ///////////////////////////////////////////////
        /*
         * for (int i = 0; i < this.m; i++) {
         * for (int j = 0; j < this.n; j++) {
         * if (matriz[i][j] == elemento) {
         * if (direccion.equalsIgnoreCase("izquierda")) {
         * for (int j2 = j; j2 > 0; j2--) {
         * numeros += matriz[i][j2] + "   ";
         * 
         * }
         * break;
         * } else if (direccion.equalsIgnoreCase("derecha")) {
         * for (int j2 = j; j2 < m; j2++) {
         * numeros += matriz[i][j2] + "   ";
         * 
         * }
         * break;
         * }
         * }
         * }
         * break;
         * }
         */
        JOptionPane.showMessageDialog(null, "Numeros: " + numeros);

    }

}
