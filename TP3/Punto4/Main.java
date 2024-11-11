package TP3.Punto4;

import utils.validaciones;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        GestorSitiosWeb gestor = new GestorSitiosWeb();

        do {
            int opcion = validaciones.validarNumIntEnVentana("INGRESE UNA OPCION" + "\n" + "------------" + "\n" +
                    "1-Agregar Sitio Web" + "\n" +
                    "2-Recorrer historial hasta encontrar un sitio a elección" + "\n" +
                    "3-Mostrar sitios visitados " + "\n" +
                    "4-Mostrar sitios por tipos" + "\n" +
                    "5-Salir");

            switch (opcion) {
                case 1:
                    agregarSitio(gestor);
                    break;
                case 2:
                    String buscar = validaciones.validarTextoVentana("Ingrese el sitio a buscar");
                    String resultado = gestor.recorrerHistorial(buscar);
                    JOptionPane.showMessageDialog(null,
                            "Recorrido de Historial" + "\n" + "-----------------------------" + "\n" + resultado);
                    break;

                case 3:
                    String mostrar = gestor.mostrarTodosLosSitios();
                    JOptionPane.showMessageDialog(null, "Sitios visitados" + "-----------------------------" + "\n"
                            + mostrar);
                    break;

                case 4:
                    String mostrarPorTipos = mostrarSitiosPorTipos(gestor);
                    JOptionPane.showMessageDialog(null, mostrarPorTipos);

                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción correcta");

                    break;
            }

        } while (!salir);

    }

    public static void agregarSitio(GestorSitiosWeb gestor) {
        String nombre = validaciones.validarTextoVentana("Nombre de la Web");
        String tipo = validarTipo();
        String url;
        do {
            url = JOptionPane.showInputDialog("URL de Web");
            if (validaciones.validarTextoVacio(url)) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");

            }
        } while (validaciones.validarTextoVacio(url));

        SitioWeb web = new SitioWeb(nombre, tipo, url);
        gestor.agregarSitio(web);
    }

    public static String validarTipo() {
        String[] tipos = { "educativo", "entretenimiento", "noticias", "comercio", "electrónico" };
        boolean esValido = false;
        String tipo;
        do {
            tipo = JOptionPane
                    .showInputDialog("Tipo de Web (educativo/entretenimiento/noticias/comercio/electrónico)")
                    .toLowerCase();
            if (tipo.length() != 0) {
                for (int i = 0; i < tipos.length; i++) {
                    if (tipo.equalsIgnoreCase(tipos[i])) {
                        esValido = true;
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } while (!esValido);

        return tipo;

    }

    public static String mostrarSitiosPorTipos(GestorSitiosWeb gestor) {
        String mostrar = "SITIOS WEB POR TIPO: " + "\n" + "-----------" + "\n";
        mostrar += gestor.mostrarSitiosPorTipo("educativo") + "\n";
        mostrar += gestor.mostrarSitiosPorTipo("entretenimiento") + "\n";
        mostrar += gestor.mostrarSitiosPorTipo("noticias") + "\n";
        mostrar += gestor.mostrarSitiosPorTipo("comercio") + "\n";
        mostrar += gestor.mostrarSitiosPorTipo("electrónico") + "\n";

        return mostrar;

    }

}
