package PARCIAL.EjerciciosParcial2;

import utils.List.Node;

/**
 * Dada esta implementación de Lista Doblemente Enlazada hacer el método size
 * del cuadro B
 * tener en cuenta que la implementación no tiene tail ni count
 */
public class punto4<E> {
    private Node<E> head;

    public punto4() {
        this.head = null;
    }

    public int size() {
        int count = 0;
        Node<E> current = this.head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
