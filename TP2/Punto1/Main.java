package TP2.Punto1;

import javax.swing.*;
import utils.validaciones;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            int tamañoArray = validaciones.validarNumIntEnVentana("Ingrese el tamaño");

            Empleado[] listaEmpleados = new Empleado[tamañoArray];
            for (int i = 0; i < tamañoArray; i++) {

                listaEmpleados[i] = agregarEmpleado(i);
            }
            String datosEmpleados = "Datos de empleados:\n";
            int num = 1;
            for (Empleado empleado : listaEmpleados) {

                datosEmpleados += empleado.mostrarDatos(num) + "\n" + "-----------------------------" + "\n";
                num++;
            }

            JOptionPane.showMessageDialog(null, datosEmpleados, "      DATOS DE EMPLEADOS",
                    JOptionPane.INFORMATION_MESSAGE);
            calcularSumaSueldosDepartamento(listaEmpleados);
        });
    }

    public static Empleado agregarEmpleado(int i) {

        Empleado empleados = new Empleado();
        int cuil = validaciones.validarNumIntEnVentana("Empleado " + (i + 1) + """
                \nIngrese el cuil
                        """);
        empleados.setCuil(cuil);

        String nombre = validaciones.validarTextoVentana("Empleado " + (i + 1) + """
                \nIngrese el Nombre Y Apellido
                        """);
        empleados.setNombreYApellido(nombre);

        LocalDate fecha = validaciones.validarFormatoFechaVentana("Empleado " + (i + 1) + """
                \nIngrese la fecha de ingreso en formato yy-mm-dd
                        """);
        empleados.setFechaIngreso(fecha);

        double sueldo = validaciones.validarNumDoubleEnVentana("Empleado " + (i + 1) + """
                \nIngrese el sueldo
                        """);
        empleados.setSueldo(sueldo);

        String departamento = validaciones.validarTextoVentana("Empleado " + (i + 1) + """
                \nIngrese el departamento
                        """);
        empleados.setDepartamento(departamento);

        return empleados;
    }

    public static void calcularSumaSueldosDepartamento(Empleado[] empleados) {
        String[] departamentos = new String[empleados.length];
        double[] sumaSueldos = new double[empleados.length];
        int numDepartamentos = 0;

        for (Empleado empleado : empleados) {
            String departamento = empleado.getDepartamento();
            Double sueldo = empleado.getSueldo();

            int index = -1;
            for (int i = 0; i < numDepartamentos; i++) {
                if (departamentos[i].equals(departamento)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                sumaSueldos[index] += sueldo;
            } else {
                departamentos[numDepartamentos] = departamento;
                sumaSueldos[numDepartamentos] = sueldo;
                numDepartamentos++;
            }
        }
        String mostrarDatos = "";
        for (int i = 0; i < numDepartamentos; i++) {
            mostrarDatos += "Departamento: " + departamentos[i] + "\n" +
                    "Sueldo: " + sumaSueldos[i] + "\n" + "-----------------------------" + "\n";
        }

        JOptionPane.showMessageDialog(null, mostrarDatos, "SUMA DE SUELDOS POR DEPARTAMENTO",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
