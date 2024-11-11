
import utils.BinaryTree.BinaryTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> nodo939 = new BinaryTree<>(939, new BinaryTree<Integer>(925), null);
        BinaryTree<Integer> nodo893 = new BinaryTree<>(893, null, nodo939);
        BinaryTree<Integer> nodo744 = new BinaryTree<>(744, new BinaryTree<Integer>(565), null);
        BinaryTree<Integer> nodo473 = new BinaryTree<>(473, null, nodo744);
        BinaryTree<Integer> nodo812 = new BinaryTree<>(812, nodo473, nodo893);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10, null, new BinaryTree<Integer>(186));
        BinaryTree<Integer> nodo459 = new BinaryTree<>(459, nodo10, nodo812);

        Integer cantidadNodos = nodo459.nodeCount();
        Integer cantidadHojas = nodo459.leafCount();
        Integer nodosInternos = nodo459.internalCount();
        Integer maxNivelArbol = nodo459.maxLevel();
        Integer alturaArbol = nodo459.height();

        /** Imprimir en pantalla la representación parentizada del árbol. **/
        System.out.println(nodo459.toString());

        /** Recorrer el árbol en orden descendente. **/
        nodo459.descendingOrder();

        System.out.println("Cantidad de nodos: " + cantidadNodos);
        System.out.println("Cantidad de Hojas: " + cantidadHojas);
        System.out.println("Cantidad de nodos internos: " + nodosInternos);
        System.out.println("Maximo nivel de arbol: " + maxNivelArbol);

        System.out.println("Altura arbol: " + alturaArbol);

    }

}
