package TP2.Punto6;

import utils.validaciones;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int m = validaciones.validarNumIntEnVentana("Ingrese el valor de M");
        int n = validaciones.validarNumIntEnVentana("Ingrese el valor de N");
        Matriz matriz = new Matriz(m, n);

        crearMatriz(matriz);
        mostrarMatriz(matriz);
        buscarElemento(matriz);
        numerosIzqDer(matriz);

    }

    public static Matriz crearMatriz(Matriz matriz) {
        matriz.llenarMatriz();
        return matriz;
    }

    public static void mostrarMatriz(Matriz matriz) {
        matriz.mostrarMatriz();
    }

    public static void buscarElemento(Matriz matriz) {
        int elementoBuscar = validaciones.validarNumIntEnVentana("Elemento a buscar");
        matriz.buscarElemento(elementoBuscar);
    }

    public static void numerosIzqDer(Matriz matriz) {
        int fila = validaciones.validarNumIntEnVentana("Fila Nº");
        int columna = validaciones.validarNumIntEnVentana("Columna Nº");
        String direccion = validaciones.validarTextoVentana("Direccion: izq o der");

        matriz.mostrarNumIzqDerecha(fila, columna, direccion);
    }

}