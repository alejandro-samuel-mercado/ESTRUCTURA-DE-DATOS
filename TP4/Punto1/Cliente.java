package TP4.Punto1;

public class Cliente {
    private int codCliente;
    private String[] aynCliente;
    private String mailCliente;

    public Cliente(int codCliente, String aynCliente[], String mailCliente) {
        this.codCliente = codCliente;
        this.aynCliente = aynCliente;
        this.mailCliente = mailCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String[] getAynCliente() {
        return aynCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Codigo cliente= " + codCliente +
                ", Nombre= " + aynCliente[0] +
                ", Apellido= " + aynCliente[1] +
                ", Email = " + mailCliente +
                '}';
    }
}
