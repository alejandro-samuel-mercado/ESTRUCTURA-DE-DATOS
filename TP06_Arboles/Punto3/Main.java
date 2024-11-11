package TP06_Arboles.Punto3;

import java.util.Scanner;

import utils.validaciones;
import utils.BinaryTree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Juguete> jugueteTree = new BinarySearchTree<>();
        Juguete[] juguetes = arrayJuguetes();
        agregarJuguetes(jugueteTree, juguetes, input);

        System.out.println("Àrbol juguetes");
        System.out.println(jugueteTree.toString());

        System.out.println("-------------------------");
        System.out.println("Recorrido preOrden");
        jugueteTree.preOrder();
        System.out.println("-------------------------");
        System.out.println("Recorrido InOrden");
        jugueteTree.inOrder();
        System.out.println("-------------------------");

    }

    public static void agregarJuguetes(BinarySearchTree<Juguete> jugueteTree, Juguete[] juguetes, Scanner input) {
        int numJuguetes;
        System.out.println("------Cantidad de juguetes disponibles: " + juguetes.length + "-----------");
        do {

            numJuguetes = validaciones.validarNumero(input, "Número de juguetes a agregar: ");

            if (numJuguetes > juguetes.length) {
                System.out.println("La cantidad debe ser menor o igual a " + juguetes.length);
            } else {
                break;
            }
        } while (true);

        for (int i = 0; i < numJuguetes; i++) {
            jugueteTree.add(juguetes[i]);

        }

    }

    public static Juguete[] arrayJuguetes() {
        Juguete[] juguetes = { new Juguete("Gorila", "Film", "Plástico", 1350.0),
                new Juguete("Godzilla", "Film", "Plástico", 1200.0),
                new Juguete("Mono", "Game", "Peluche", 1900.0),
                new Juguete("Barbie", "film", "Plástico", 1500.0),
                new Juguete("Ken", "Film", "Plástico", 1800.0),
                new Juguete("Nave k10", "Toy k", "Goma", 900.0),
                new Juguete("Godzilla1", "Film", "Plástico", 600.0),
                new Juguete("Godzilla2", "Film", "Plástico", 2000.0),
                new Juguete("Godzill3", "Film", "Plástico", 700.0),
                new Juguete("Godzilla4", "Film", "Plástico", 1600.0),
                new Juguete("Saltarín", "Children", "Goma", 100.0),
                new Juguete("Pistola", "Police", "Plástico", 300.0),
                new Juguete("Arco y flecha", "Film", "Plástico", 500.0),
        };
        return juguetes;
    }
}
