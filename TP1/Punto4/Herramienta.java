package TP1.Punto4;

import java.util.Scanner;
import utils.validaciones;

public class Herramienta {

    private int codigo;
    private String nombre;
    private int cantidad;
    private double precioUntario;
    private String tipo;

    // Constructor parametrizado (inicializa todos los atributos)
    public Herramienta(int codigo, String nombre, int cantidad, double precioUnitario, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
        if (precioUnitario > 0) {
            this.precioUntario = precioUnitario;
        }
        this.tipo = tipo;
    }

    public Herramienta(int codigo, String nombre, Double precioUntario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUntario = precioUntario;
    }

    public Double calcularValor() {
        Double valorTotal = this.cantidad * this.precioUntario;
        return valorTotal;
    }

    public void entregarCantidad(Scanner input) {
        int cantidadSolicitada;
        do {
            cantidadSolicitada = validaciones.validarNumero(input, "Ingrese la cantidad solicitada: ");
            input.nextLine();
            if (cantidadSolicitada <= this.cantidad) {
                this.cantidad -= cantidadSolicitada;
                break;
            } else {
                System.out.println("La cantidad disponible es menor a la solicitada. Intente con otra cantidad");
            }

        } while (true);
    }

    public String mostrarInfoEspecifica(Scanner input, String tipoABuscar) {
        String resultado = "";
        boolean encontrado = false;

        if (this.tipo.equals(tipoABuscar)) {
            resultado = "Tipo: " + this.tipo + ", " + "Nombre: " + this.nombre + ", " + "Precio: "
                    + this.precioUntario;
            encontrado = true;

        }

        if (!encontrado) {
            resultado = "No se encontró el tipo";
        }
        return resultado;

    }

    public String toString() {
        String resultado = "Herramienta[ nombre: " + this.nombre + ", " + "Tipo: " + this.tipo + ", " + "Precio: "
                + this.precioUntario + ", " + "Cantidad disponible: " + this.cantidad;
        return resultado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecioUnitario() {
        return this.precioUntario;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
