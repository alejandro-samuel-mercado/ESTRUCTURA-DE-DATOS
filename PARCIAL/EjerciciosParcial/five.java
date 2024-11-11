package PARCIAL.EjerciciosParcial;

/**
 * Dada una matriz de orden MxN, realizar:
 * a) La suma de los elementos de cada fila y guardar el resultado en un vector.
 * (ver figura A)
 * b) Obtener el elemento mínimo de cada columna y guardarlo en un vector
 * (ver figura A)
 * La solución debe ser modular
 **/

public class five {
    public static void main(String[] args) {

        int[][] matriz = { { 2, 4, 6 }, { 1, 3, 7 }, { 9, 5, 8 } };
        sumarElementosCadaFila(matriz);
        minimoCadaColumna(matriz);
    }

    public static void sumarElementosCadaFila(int[][] matriz) {
        int[] matrizSuma = new int[matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            matrizSuma[i] = sumaFila;
        }

        for (int i = 0; i < matrizSuma.length; i++) {
            System.out.printf(matrizSuma[i] + " ");
        }
        System.out.println("");
    }

    public static void minimoCadaColumna(int[][] matriz) {

        int[] minimoColumna = new int[matriz.length];
        for (int i = 0; i < matriz[0].length; i++) {
            int minimo = 100;
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j][i] < minimo) {
                    minimo = matriz[j][i];
                }
            }
            minimoColumna[i] = minimo;
        }
        for (int i = 0; i < minimoColumna.length; i++) {
            System.out.printf(minimoColumna[i] + " ");
        }
        System.out.println("");

    }
}
