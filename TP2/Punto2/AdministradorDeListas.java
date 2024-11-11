package TP2.Punto2;

import java.util.ArrayList;

public class AdministradorDeListas {
    private ArrayList<String> lista;

    public AdministradorDeListas() {
        lista = new ArrayList<>();
    }

    public void añadirElementoDeArray(String elemento) {
        lista.add(elemento);
    }

    public void eliminarElementoDeArray(String elemento) {
        lista.remove(elemento);
    }

    public boolean buscarElementoDeArray(String elemento) {
        return lista.contains(elemento);
    }

    public String mostrarElemento() {
        int num = 1;
        String datos = "Lista" + num + "\n";
        for (String elemento : lista) {
            datos += elemento + ", ";
            num++;
        }
        return datos;
    }
}
