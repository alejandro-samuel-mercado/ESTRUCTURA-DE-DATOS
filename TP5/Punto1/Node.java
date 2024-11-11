package TP5.Punto1;

/**
 * Node
 */
public class Node<E> {

    public E item;
    public Node<E> next;
    public Node<E> prev;

    /** Constructor por defecto */
    public Node() {
        this.item = null;
        this.next = null;
        this.prev = null;
    }

    /** Constructor especializado */
    public Node(E item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    /** Constructor especializado para simple */
    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
        this.prev = null;
    }

    /** Constructor especializado para doblemente enlazada */
    public Node(E item, Node<E> next, Node<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public String toString() {
        return this.item.toString();
    }

    /** Getters y Setters */
    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

}