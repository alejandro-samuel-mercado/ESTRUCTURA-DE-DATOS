package TP2.Punto5;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class IntersecciónArray {
    char[] array1;
    char[] array2;

    public IntersecciónArray(char[] array1, char[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public void encontrarInterseccion() {
        ArrayList<Character> inteseccion = new ArrayList<>();
        for (char c1 : array1) {
            for (char c2 : array2) {
                if (c1 == c2 && !(inteseccion.contains(c1))) {
                    inteseccion.add(c1);
                    break;
                }
            }
        }
        mostrarInterseccion(inteseccion);
    }

    public void mostrarInterseccion(ArrayList<Character> inteseccion) {
        String datos = "Elementos en intersección: " + "\n";
        for (Character ch : inteseccion) {
            datos += ch + "\n";
        }
        JOptionPane.showMessageDialog(null, datos);

    }

}
