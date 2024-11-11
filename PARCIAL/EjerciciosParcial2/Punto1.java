package PARCIAL.EjerciciosParcial2;

import java.time.LocalDate;
import java.util.Scanner;

import PARCIAL.Resuelto.Empleado;
import utils.List.SingleLinkedList;

/**
 * Dada una lista de empleados realizar los métodos:
 * a) Hacer un método que cuente los empleados que
 * coincidan con una subcadena (un apellido) dado por
 * el usuario y un monto (el salario) que supere el
 * salario actual del empleado.
 * b) Retorne otra lista que contenga a los empleados
 * de un sector dado.
 */
public class Punto1 {
    public static void main(String[] args) {
        SingleLinkedList<Empleado> empleados = new SingleLinkedList<>();
        Scanner input = new Scanner(System.in);
        agregarEmpleados(empleados);
        int cantidad = contarEmpleadosConSubCadenaYSalario(empleados, input);
        System.out.println("Cantidad de empleados que coinciden:" + cantidad);

        SingleLinkedList<Empleado> nuevaLista = empleadosDeUnSector(empleados, input);
        nuevaLista.mostrar();

        input.close();
    }

    public static void agregarEmpleados(SingleLinkedList<Empleado> empleados) {
        Empleado[] arrayEmpleados = {
                new Empleado(01, 214324, "lalo", "12-12-2000", "yaya@yaya", 15, 300.0),
                new Empleado(0121, 5324324, "lala", "12-12-2000", "sbsj@sjs", 15, 100.0),
                new Empleado(021, 25344324, "sal", "12-12-2000", "sbsj@sjs", 15, 500.0),
                new Empleado(032121, 54314324, "lale", "12-12-2000", "sbsj@sjs", 15, 900.0),
                new Empleado(0321, 253424, "dalo", "12-12-2000", "sbsj@sjs", 15, 2200.0),
                new Empleado(051, 2142344, "alo", "12-12-2000", "sbsj@sjs", 15, 1200.0),
                new Empleado(016, 21435554, "palo", "12-12-2000", "sbsj@sjs", 15, 400.0),
                new Empleado(071, 2334324, "malo", "12-12-2000", "sbsj@sjs", 15, 300.0),
                new Empleado(123, 2144324, "balo", "12-12-2000", "sbsj@sjs", 15, 700.0),
                new Empleado(014, 2145524, "talo", "12-12-2000", "sbsj@sjs", 15, 100.0),

        };

        for (Empleado empleado : arrayEmpleados) {
            empleados.addLast(empleado);
        }
    }

    public static int contarEmpleadosConSubCadenaYSalario(SingleLinkedList<Empleado> empleados, Scanner input) {
        int count = 0;
        System.out.printf("Ingrese apellido a buscar: ");
        String apellido = input.nextLine();
        System.out.printf("Ingrese salario minímo : ");
        Double salarioMin = (double) input.nextInt();
        input.nextLine();

        for (Empleado empleado : empleados) {
            if ((empleado.getNombre().equalsIgnoreCase(apellido)) && (empleado.getSaldo() > salarioMin)) {
                count++;
            }
        }
        return count;
    }

    public static SingleLinkedList<Empleado> empleadosDeUnSector(SingleLinkedList<Empleado> empleados, Scanner input) {
        SingleLinkedList<Empleado> nuevaLista = new SingleLinkedList<Empleado>();
        System.out.printf("Sector a buscar: ");
        String sector = input.nextLine();
        for (Empleado empleado : empleados) {
            if (empleado.getCorreo().equalsIgnoreCase(sector)) {
                nuevaLista.addLast(empleado);
            }
        }
        return nuevaLista;
    }

}
