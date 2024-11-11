package TP2.Punto2;

import utils.validaciones;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            AdministradorDeListas adminListas = new AdministradorDeListas();
            opciones(adminListas);
        });
    }

    public static void opciones(AdministradorDeListas listas) {

        boolean salir = false;
        while (!salir) {
            int opcion = validaciones.validarNumIntEnVentana("Ingrese una opción");
            switch (opcion) {
                case 1:
                    agregarElemento(listas);

                    break;
                case 2:
                    mostrarElementos(listas);

                    break;
                case 3:
                    eliminarElemento(listas);

                    break;
                case 4:
                    buscarElemento(listas);

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    salir = true;
                default:
                    break;
            }
        }

    }

    public static void agregarElemento(AdministradorDeListas listas) {
        int cantidadListas = validaciones.validarNumIntEnVentana("Cantidad de listas a agregar");
        for (int index = 0; index < cantidadListas; index++) {
            int cantidadElementos = validaciones
                    .validarNumIntEnVentana("Cantidad de elementos a agregar en la lista " + (index + 1));
            for (int i = 0; i < cantidadElementos; i++) {
                String elemento = validaciones.validarTextoVentana("Elemento " + (i + 1));
                listas.añadirElementoDeArray(elemento);
            }

        }
    }

    public static void mostrarElementos(AdministradorDeListas listas) {
        String datos = listas.mostrarElemento();
        JOptionPane.showMessageDialog(null, datos.toString(), "Elementos en las Listas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void eliminarElemento(AdministradorDeListas lista) {
        String elemento = validaciones.validarTextoVentana("Elemento a ingresar");
        try {
            lista.eliminarElementoDeArray(elemento);
            JOptionPane.showMessageDialog(null, "Elemento eliminado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, no existe el elemento");

        }

    }

    public static void buscarElemento(AdministradorDeListas lista) {
        String elemento = validaciones.validarTextoVentana("Elemento a buscar");
        if (lista.buscarElementoDeArray(elemento)) {
            JOptionPane.showMessageDialog(null, "El elemento fue encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el elemento");

        }
    }

}
