package TP3.Punto3;

import TP3.Stack;

import javax.swing.*;

public class GPS {
    private Stack<Ruta> pilaRutas = new Stack<>();
    private Stack<Ruta> pilaDeshacer = new Stack<>();

    public void agregarRuta(Ruta ruta) {
        pilaRutas.push(ruta);
    }

    public void deshacerRuta() {
        if (!pilaRutas.isEmpty()) {
            Ruta ultimaRutaAgregada = pilaRutas.pop(); // Quita el ultimo elemento de pilasRutas
            pilaDeshacer.push(ultimaRutaAgregada); // Y se lo agrega en deshacer
        } else {
            JOptionPane.showMessageDialog(null, "No hay rutas para deshacer");
        }

    }

    public void rehacerRuta() {
        if (!pilaRutas.isEmpty()) {
            Ruta ultimaRutaDeshacer = pilaDeshacer.pop();// Quita el ultimo elemento de pilasDeshacer
            pilaRutas.push(ultimaRutaDeshacer);// Y se lo agrega nuevamente en la pilaRutas orginal
        } else {
            JOptionPane.showMessageDialog(null, "No hay rutas para rehacer");

        }
    }

    public void verRutaActual() {
        if (!pilaRutas.isEmpty()) {
            JOptionPane.showMessageDialog(null, pilaRutas.peek());

        } else {
            JOptionPane.showMessageDialog(null, "No hay rutas agregadas");
        }
    }

    public void verHistorialCompleto() {
        String historial = "";
        if (!pilaRutas.isEmpty()) {
            for (Ruta ruta : pilaRutas) {
                historial += ruta.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, "HistorialCompleto: " + "\n" + historial);

        } else {
            JOptionPane.showMessageDialog(null, "No hay rutas en el historial");
        }
    }
}
