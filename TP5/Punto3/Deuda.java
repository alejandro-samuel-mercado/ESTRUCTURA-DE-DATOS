package TP5.Punto3;

public class Deuda {
    private String codigo;
    private String descripcion;
    private String nombreAcreedor;
    private String fechaDeuda;
    private Double monto;

    public Deuda(String codigo, String descripcion, String nombreAcreedor, String fechaDeuda, Double monto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombreAcreedor = nombreAcreedor;
        this.fechaDeuda = fechaDeuda;
        this.monto = monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreAcreedor() {
        return nombreAcreedor;
    }

    @Override
    public String toString() {
        return "[Código: " + this.codigo + ", Descripción: " + this.descripcion + ", Nombre del acreedor: "
                + this.nombreAcreedor + ", Fecha de deuda: " + this.fechaDeuda + ", Monto: " + this.monto + "]";
    }
}
