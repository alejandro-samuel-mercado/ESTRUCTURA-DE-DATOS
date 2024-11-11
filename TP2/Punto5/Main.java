package TP2.Punto5;

import javax.swing.JOptionPane;
import utils.validaciones;

public class Main {
    public static void main(String[] args) {
        IntersecciónArray conjuntoArrays = agregarCaracteres();
        conjuntoArrays.encontrarInterseccion();
    }

    public static IntersecciónArray agregarCaracteres() {

        int numCaracteres1 = validaciones.validarNumIntEnVentana("Cantidad de carácteres de Array1");
        char[] array1 = new char[numCaracteres1];
        for (int i = 0; i < numCaracteres1; i++) {
            char caracter = validarCaracter("Ingresar un caracter");
            array1[i] = caracter;
        }

        int numCaracteres2 = validaciones.validarNumIntEnVentana("Cantidad de carácteres de Array2");
        char[] array2 = new char[numCaracteres2];
        for (int i = 0; i < numCaracteres2; i++) {
            char caracter = validarCaracter("Ingresar un caracter");
            array2[i] = caracter;
        }

        IntersecciónArray conjuntoArrays = new IntersecciónArray(array1, array2);
        return conjuntoArrays;
    }

    public static char validarCaracter(String mensaje) {
        String input = "";
        do {
            input = JOptionPane.showInputDialog(mensaje);

            if (validarTextoVacio(input)) {
                JOptionPane.showMessageDialog(null, "El campo está vacío. Ingrese un valor.");
            } else if (!esSoloCaracter(input)) {
                JOptionPane.showMessageDialog(null, """
                        Error, el valor solo debe contener caracteres alfabéticos.
                        \nIngrese otro valor
                        """);
            }
        } while (validarTextoVacio(input) || !esSoloCaracter(input));
        return input.charAt(0);
    }

    public static boolean validarTextoVacio(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean esSoloCaracter(String input) {
        return input.length() == 1 && Character.isLetter(input.charAt(0));
    }

}
