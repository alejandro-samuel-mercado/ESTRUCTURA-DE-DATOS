package TP5.Punto7;

import utils.List.SingleLinkedList;

public class Queue<ELEMENT> {
    private SingleLinkedList<ELEMENT> list;

    public Queue() {
        this.list = new SingleLinkedList<>();
    }

    // Método para añadir un elemento a la cola
    public void add(ELEMENT element) {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        list.addLast(element);
    }

    // Método para añadir un elemento sin lanzar excepción en caso de error
    public boolean offer(ELEMENT element) {
        if (isEmpty()) {
            return false;
        }
        list.addLast(element);
        return true;
    }

    // Método para devolver el primer elemento sin eliminarlo (lanza excepción si
    // está vacía)
    public ELEMENT element() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return list.getFirst();
    }

    // Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
    // devuelve null)
    public ELEMENT peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    // Método para eliminar y devolver el primer elemento (lanza excepción si está
    // vacía)
    public ELEMENT remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        ELEMENT element = list.removeFirst();
        return element;
    }

    // Método para eliminar y devolver el primer elemento (retorna null si está
    // vacía)
    public ELEMENT poll() {
        if (isEmpty()) {
            return null;
        }
        ELEMENT element = list.removeFirst();
        return element;
    }

    // Método para obtener el tamaño actual de la cola
    public int size() {
        return this.list.size();
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

}
