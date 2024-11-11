package TP1.Punto2;

import java.util.Scanner;

public class ArticuloDeLibreria {

    private int codigo;
    private String nombre;
    private float precio;
    private int cantidad;

    public ArticuloDeLibreria() {
        this.precio = 0;
        this.cantidad = 0;
    }

    public void depositarEnStock(int cantidad) {
        this.cantidad += cantidad;
    }

    public int retirarDeStock(Scanner scanner) {
        int cantidad;
        do {
            System.out.println("Cantidad a retirar: ");
            cantidad = scanner.nextInt();
            if (this.cantidad >= cantidad) {
                this.cantidad -= cantidad;
                return this.cantidad;
            } else {
                System.out.println("No hay fondos");
            }

        } while (true);

    }

    public String toStringg() {
        String detalle = this.codigo + "----" + this.nombre + "----" + this.precio + "----" + this.cantidad;
        return detalle;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
