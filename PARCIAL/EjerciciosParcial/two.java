package PARCIAL.EjerciciosParcial;

/**
 * Dada una matriz unidimensional de tamaño N(múltiplo de 3) con datos, y
 * a) dada una matriz de 3 columnas y x filas, Crear una matriz nueva y
 * agregarle datos.
 * X se calcula con un N y el nº de columnas.
 * 
 * b) calcular el mínimo de la matriz y la posición
 **/
public class two {
    public static void main(String[] args) {
        int[] matrizUnid = { 1, 2, 3, 4, 0, 6 }; // Múltiplo de 3

        // a)
        int columnas = 3;
        int filas = matrizUnid.length / columnas;
        int[][] nuevaMatriz = new int[filas][columnas];

        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[i][j] = matrizUnid[indice];
                indice++;
            }

        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf(nuevaMatriz[i][j] + " ");
            }
            System.out.println("");
        }

        // b)
        System.out.println("-------------");

        int minimo = nuevaMatriz[0][0];
        int posColumna = 0;
        int posFila = 0;
        for (int i = 0; i < nuevaMatriz.length; i++) {
            for (int j = 0; j < nuevaMatriz[i].length; j++) {
                if (nuevaMatriz[i][j] < minimo) {
                    minimo = nuevaMatriz[i][j];
                    posFila = i;
                    posColumna = j;
                }

            }
        }
        System.out.println(
                "EL minímo es: " + minimo + ", y está en la posición" + "[" + posFila + "]" + "[" + posColumna + "]");

    }
}
