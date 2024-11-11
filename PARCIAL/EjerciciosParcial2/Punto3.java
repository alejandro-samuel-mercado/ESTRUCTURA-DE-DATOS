package PARCIAL.EjerciciosParcial2;

import java.util.Scanner;

import utils.List.SingleLinkedList;

/**
 * Dada una lista de medicos realizar los métodos:
 * a) Hacer un método modular que calcule el promedio
 * de los salarios de una especialidad dada por el
 * usuario.
 * b) Hacer un método que dado una cadena dada por el
 * usuario coincide con un apellido de la lista de
 * medicos y añadirlos a una nueva lista.
 */
public class Punto3 {
    public static void main(String[] args) {
        SingleLinkedList<Medico> medicos = new SingleLinkedList<>();
        Scanner input = new Scanner(System.in);
        cargarMedicos(medicos);
        Double promedioPorEspecialidad = promedioEspecialidad(medicos, input);
        System.out.println("Promedio: " + promedioPorEspecialidad);

        SingleLinkedList<Medico> nuevaLista = listarPorApellido(medicos, input);
        System.out.println(nuevaLista.toString());

    }

    public static void cargarMedicos(SingleLinkedList<Medico> medicos) {
        Medico[] arrayMedicos = {
                new Medico("lalo", "sala", "cirujano", 3000.0),
                new Medico("Ali", "Carpenter", "cardio", 10000.0),
                new Medico("Aladin", "Pola", "cirujano", 1000.0),
                new Medico("Abil", "Benicio", "pediatra", 5600.0),
                new Medico("Sol", "Mercado", "cirujano", 2000.0),
        };
        for (Medico medico : arrayMedicos) {
            medicos.addLast(medico);
        }
    }

    public static Double promedioEspecialidad(SingleLinkedList<Medico> medicos, Scanner input) {
        Double promedio = 0.0;
        int count = 0;
        Double suma = 0.0;
        System.out.printf("Especialidad: ");
        String especialidad = input.nextLine();
        for (Medico medico : medicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                suma += medico.getSalario();
                count++;
            }
        }
        promedio = (double) (suma / count);
        return promedio;
    }

    public static SingleLinkedList<Medico> listarPorApellido(SingleLinkedList<Medico> medicos, Scanner input) {
        SingleLinkedList<Medico> nuevaLista = new SingleLinkedList<>();
        System.out.printf("Apellido a buscar: ");
        String apellidoABuscar = input.nextLine();
        for (Medico medico : medicos) {
            if (medico.getApellido().equalsIgnoreCase(apellidoABuscar)) {
                nuevaLista.addLast(medico);
            }
        }
        return nuevaLista;
    }

}
