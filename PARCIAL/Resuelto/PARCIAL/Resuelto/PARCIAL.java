package PARCIAL.Resuelto;

import java.util.Scanner;
import utils.Queue.Queue;
import utils.Stack.Stack;

public class PARCIAL {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /** -----------Punto 1---------- */

        // a) Dada la clase empleados cargados en una cola inicial, devolver una cola
        // con los empleados que tienen una edad mayor a una edad ingresasa
        Queue<Empleado> inicial = new Queue<>();
        Queue<Empleado> mayores = new Queue<>();
        inicial.add(new Empleado(0, 0, "Lalo", null, null, 12, 200.50));
        inicial.add(new Empleado(0, 0, "José", null, null, 23, 500.12));
        inicial.add(new Empleado(0, 0, "Seba", null, null, 52, 150.70));
        mayores = colaPorEdad(inicial, 20);

        System.out.println("\n----Empleados mayores a " + 20 + " años");
        while (!mayores.isEmpty()) {
            System.out.println(mayores.poll());
        }
        System.out.println("-------------------");

        // b)Calcular el promedio del sueldo de los empleados de la cola inicial o la
        // cola de mayores
        promedioSueldo(mayores, inicial, input);

        /*------------- Punto 2------- */
        boolean esPalindromo = verificarPalindromo("reconocer");
        if (esPalindromo) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }

        /** -------Punto 3-------- */
        // a) Dados dos vectores unidimensionales, devolver otro vector con los
        // elementos de A que no están en B
        int A[] = { 1, 2, 3, 4, 5 };
        int B[] = { 2, 4, 5, 6, 7 };
        diferenciaAB(A, B);
        System.out.println("");

        // b) Dado un número, encontrar los valores de A que son múltiplos de dicho
        // número
        esMultiplo(A, 2);

        /*------- Punto 4 -----------*/
        // a)
        resultadoMultiplicacion(5);
        // Resultado -> 120

        // b)
        Queue<Integer> nombres = new Queue<>();
        nombres.add(1);
        nombres.add(2);
        nombres.add(3);
        nombres.add(4);
        System.out.println(nombres.poll());
        System.out.println(nombres.peek());
        // Resultado-> 1 2

    }

    public static Queue<Empleado> colaPorEdad(Queue<Empleado> inicial, int edad) {
        Queue<Empleado> mayores = new Queue<>();
        while (!inicial.isEmpty()) {
            Empleado empleado = inicial.poll();
            if (empleado.getEdad() > edad) {
                mayores.add(empleado);
            }
        }
        return mayores;
    }

    public static Double promedioSueldo(Queue<Empleado> mayores, Queue<Empleado> inicial, Scanner input) {
        Double suma = 0.0;
        Double promedio = 0.0;
        System.out.println("Cola a calcular: inicial(i) o mayores(m)");
        String opcion = input.nextLine().toLowerCase();
        if (opcion == "m") {
            while (!mayores.isEmpty()) {
                Empleado empleado = mayores.poll();
                suma += empleado.getSaldo();
            }
            promedio = suma / mayores.size();
        } else if (opcion == "i") {
            while (!mayores.isEmpty()) {
                Empleado empleado = inicial.poll();
                suma += empleado.getSaldo();
            }
            promedio = suma / mayores.size();
        }
        return promedio;

    }

    public static boolean verificarPalindromo(String palabra) {
        Stack<Character> pila = new Stack<>(palabra.length());
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }
        String palabraAlreves = "";
        while (!pila.isEmpty()) {
            palabraAlreves += pila.pop();
        }

        if (palabra.equalsIgnoreCase(palabraAlreves)) {
            return true;
        }
        return false;

    }

    public static void diferenciaAB(int[] A, int[] B) {
        int[] AB = new int[A.length];
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            boolean existe = false;
            for (int j = 0; j < B.length; j++) {
                if (A[i] == (B[j])) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                AB[pos] = A[i];
                pos++;
            }
        }

        for (int i = 0; i < AB.length; i++) {
            System.out.printf(AB[i] + " ");
        }

    }

    public static void esMultiplo(int[] A, int num) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] % num == 0) {
                System.out.printf("Es múltiplo: " + A[i] + "\n");
            }
        }
    }

    public static void resultadoMultiplicacion(int n) {
        Stack<Integer> num = new Stack<>();
        int resultado = 1;
        while (n > 0) {
            num.push(n);
            n--;
        }

        while (!num.isEmpty()) {
            resultado *= num.pop();
        }
        System.out.println(resultado);
    }

}