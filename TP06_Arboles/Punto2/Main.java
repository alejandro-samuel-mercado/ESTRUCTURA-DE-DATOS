package TP06_Arboles.Punto2;

import utils.BinaryTree.BinaryTree;

public class Main {
        public static void main(String[] args) {

                System.out.println("ARBOL A");
                arbolA();
                System.out.println("---------------------");
                System.out.println("ARBOL B");
                arbolB();

        }

        public static void arbolA() {
                BinaryTree<Integer> nodo80 = new BinaryTree<Integer>(80, new BinaryTree<Integer>(70),
                                new BinaryTree<Integer>(90));
                BinaryTree<Integer> nodo30 = new BinaryTree<Integer>(30, new BinaryTree<Integer>(20),
                                new BinaryTree<Integer>(35));
                BinaryTree<Integer> nodo45 = new BinaryTree<Integer>(45, null,
                                new BinaryTree<Integer>(48));
                BinaryTree<Integer> nodo40 = new BinaryTree<Integer>(40, nodo30, nodo45);
                BinaryTree<Integer> nodo50 = new BinaryTree<Integer>(50, nodo40, nodo80);

                System.out.printf("Recorrido en orden: ");
                nodo50.inOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en pre orden: ");
                nodo50.preOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en post orden: ");
                nodo50.postOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en orden descendente: ");
                nodo50.descendingOrder();
                System.out.println("------------");

        }

        public static void arbolB() {
                BinaryTree<Integer> nodo357 = new BinaryTree<Integer>(357, null,
                                new BinaryTree<Integer>(490));
                BinaryTree<Integer> nodo513 = new BinaryTree<Integer>(513, nodo357,
                                null);
                BinaryTree<Integer> nodo546 = new BinaryTree<Integer>(546, nodo513,
                                new BinaryTree<Integer>(864));
                BinaryTree<Integer> nodo206 = new BinaryTree<Integer>(206, new BinaryTree<Integer>(198),
                                null);
                BinaryTree<Integer> nodo86 = new BinaryTree<Integer>(86, new BinaryTree<Integer>(72),
                                nodo206);
                BinaryTree<Integer> nodo310 = new BinaryTree<Integer>(310, nodo86,
                                nodo546);

                System.out.printf("Recorrido en orden: ");
                nodo310.inOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en pre orden: ");
                nodo310.preOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en post orden: ");
                nodo310.postOrder();
                System.out.println("------------");

                System.out.printf("Recorrido en orden descendente: ");
                nodo310.descendingOrder();
                System.out.println("------------");

        }
}
