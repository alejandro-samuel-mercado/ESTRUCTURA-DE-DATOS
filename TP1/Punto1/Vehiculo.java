package TP1.Punto1;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String tipoMotor;

    public Vehiculo() {
        this.marca = "Desconocida";
        this.modelo = "Sin modelo";
        this.tipoMotor = "Desconocido";
    }

    public Vehiculo(String marca, String modelo, String tipoMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
    }

    public String toString() {
        String vehiculo = "Marca: " + marca + "------ " + "Modelo:" + modelo + "----- " + "Tipo de motor: " + tipoMotor;
        return vehiculo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getTipoMotor() {
        return this.tipoMotor;
    }
}
