package PARCIAL.EjerciciosParcial2;

import utils.List.Node;

//DoubleLinkedList
public class Punto2<E> {
    private Node<E> head;
    private int count;

    public Punto2() {
        this.head = null;
        this.count = 0;
    }

    public E removeLast() {
        E element = null;
        if (this.count <= 0) {
            throw new IllegalStateException("Lista vacía");
        }
        if (this.count == 1) {
            element = this.head.item;
            this.head = null;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            element = current.item;
            current.prev.next = null;
        }
        this.count--;

        return element;
    }

}
