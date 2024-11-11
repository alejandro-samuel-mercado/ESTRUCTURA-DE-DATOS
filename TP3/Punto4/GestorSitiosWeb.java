package TP3.Punto4;

import TP3.Stack;

public class GestorSitiosWeb {
    Stack<SitioWeb> historialNavegacion;
    Stack<SitioWeb> aux;

    public GestorSitiosWeb() {
        historialNavegacion = new Stack<>();
        aux = new Stack<>();
    }

    public void agregarSitio(SitioWeb web) {
        historialNavegacion.push(web);
    }

    public String recorrerHistorial(String nombreOUrl) {
        boolean encontrado = false;
        String historial = "";

        // Busca un sitio web en el historial original
        while (!encontrado && !historialNavegacion.isEmpty()) {
            if (!historialNavegacion.isEmpty()) {
                SitioWeb elemento = historialNavegacion.pop(); // Obtiene el ultimo Sitio del historial y lo quita

                // Si encuentra al sitio lo señala
                if (nombreOUrl.equals(elemento.getNombre()) || nombreOUrl.equals(elemento.getUrl())) {
                    historial += elemento.toString() + "<------Aquí" + "\n";
                    aux.push(elemento);
                    encontrado = true;

                    // Si no encuentra al sitio:
                } else {
                    aux.push(elemento); // Agrega el sitio a un auxiliar para recuperarlo luego
                    historial += elemento.toString() + "\n";
                }
            }
        }
        // Devuelve los elementos al historial(pila) original
        while (!aux.isEmpty()) {
            SitioWeb elemento = aux.pop();
            historialNavegacion.push(elemento);
        }

        if (!encontrado) {
            historial = "SitioWeb no encontrado";
        }

        return historial;
    }

    public String mostrarTodosLosSitios() {
        String historial = "";

        // Recorre la pila sin modificarla
        for (SitioWeb web : historialNavegacion) {
            historial += web + "\n";
        }

        if (historialNavegacion.isEmpty()) {
            historial = "No se han visitado sitios";
        }

        return historial.toString();
    }

    public String mostrarSitiosPorTipo(String tipo) {
        String sitiosPorTipo = tipo.toUpperCase() + " : \n";
        boolean encontrado = false;

        for (SitioWeb sitio : historialNavegacion) {
            if (sitio.getTipo().equalsIgnoreCase(tipo)) {
                sitiosPorTipo += sitio.toString() + "\n";
                encontrado = true;
            }
        }

        if (!encontrado) {
            sitiosPorTipo += "No se encontraron sitios del tipo especificado.\n";
        }

        return sitiosPorTipo;
    }
}
