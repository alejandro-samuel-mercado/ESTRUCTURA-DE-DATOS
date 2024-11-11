package TP4.Punto1;

import java.util.Scanner;
import utils.validaciones;
import utils.Queue.*;

public class Main {
    public static void main(String[] args) {
        Queue<Cliente> colaClientes = new Queue<>();
        Queue<Cliente> colaTemporal = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        int cantidadClientesAtendidos = 0;

        agregarCliente(cantidadClientesAtendidos, colaClientes, scanner);
        atenderClientes(colaClientes, colaTemporal, cantidadClientesAtendidos);
        contarClientesPorApellido(colaClientes, colaTemporal, scanner);
    }

    public static void agregarCliente(int numClientes, Queue<Cliente> colaClientes, Scanner scanner) {

        numClientes = validaciones.validarNumero(scanner, "Ingrese el número de clientes a atender: ");

        for (int i = 0; i < numClientes; i++) {
            int codCliente = validaciones.validarNumero(scanner, "Ingrese el código del cliente " + (i + 1) + ": ");

            String nCliente = validaciones.validarTextoIngresado(scanner, "Ingrese nombre/s del cliente: ");
            String aCliente = validaciones.validarTextoIngresado(scanner, "Ingrese el apellido del cliente: ");
            String[] aynCliente = { nCliente, aCliente };
            String mailCliente = validaciones.validarMail(scanner, "Ingrese el email del cliente: ");
            System.out.println();
            Cliente cliente = new Cliente(codCliente, aynCliente, mailCliente);
            colaClientes.add(cliente);
        }
    }

    public static void atenderClientes(Queue<Cliente> colaClientes, Queue<Cliente> colaTemporal, int cantidadClientes) {
        // Simulación de atención a los clientes
        while (!colaClientes.isEmpty()) {
            Cliente clienteAtendido = colaClientes.poll();
            System.out.println("Atendiendo: " + clienteAtendido);
            colaTemporal.add(clienteAtendido);
            cantidadClientes++;
        }
        System.out.println("Total de clientes atendidos: " + cantidadClientes);

    }

    public static void contarClientesPorApellido(Queue<Cliente> colaClientes, Queue<Cliente> colaTemporal,
            Scanner scanner) {
        // Contar clientes cuyo apellido coincide con uno ingresado
        System.out.println("Ingrese un apellido para contar coincidencias:");
        String apellidoBuscado = scanner.nextLine();
        int contadorCoincidencias = 0;

        while (!colaTemporal.isEmpty()) {
            Cliente cliente = colaTemporal.poll();
            if (cliente.getAynCliente()[1].equalsIgnoreCase(apellidoBuscado)) {
                contadorCoincidencias++;
            }
        }

        System.out.println("Total de clientes con apellido '" + apellidoBuscado + "': " + contadorCoincidencias);

        scanner.close();
    }
}
