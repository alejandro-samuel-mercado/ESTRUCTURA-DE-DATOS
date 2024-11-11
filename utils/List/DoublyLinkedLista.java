package utils.List;

import java.util.Iterator;

public class DoublyLinkedLista<E> implements ILinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedLista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, null, null);
        if (isEmpty()) {
            this.tail = this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void betterAddFirst(E item) {
        Node<E> newNode = new Node<>(item, this.head, null);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null, null);
        if (isEmpty()) {
            this.tail = this.head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void betterAddLast(E item) {
        Node<E> newNode = new Node<>(item, null, this.tail);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("vacío");
        }
        E e = this.head.item;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return e;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("vacío");
        }
        E e = this.head.item;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return e;
    }

    public E get(int index) {
        Node<E> current = this.head;
        E element = null;
        if (0 <= index && index < this.size) {
            for (int i = 0; i < this.size && i != index; i++) {
                current = current.next;
            }
            element = current.item;
        } else {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
        return element;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean contains(E item) {
        Node<E> current = this.head;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addAtPosition(int pos, E item) {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException("Fuera");
        }
        if (pos == 0) {
            addFirst(item);
        } else if (pos == this.size) {
            addLast(item);
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(item, current, current.next);
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            this.size++;
        }

    }

    public void remove(E item) {
        if (isEmpty()) {
            throw new IllegalStateException("vacía");
        }
        if (this.head.item.equals(item)) {
            removeFirst();
            return;
        } else if (this.tail.item.equals(item)) {
            removeLast();
            return;
        } else {
            Node<E> current = this.head;
            while (current != null) {
                if (current.next.item.equals(item)) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    if (current.next == tail) {
                        this.tail = current;
                    }
                    this.size--;
                    return;
                }
                current = current.next;
            }
        }
    }

    public void removeDuplicate() {
        if (isEmpty()) {
            throw new IllegalStateException("vacia");
        }
        Node<E> current = this.head;
        while (current != null) {
            Node<E> innerCurrent = current.next;
            while (innerCurrent.next != null) {
                if (current.item.equals(innerCurrent.item)) {
                    Node<E> duplicate = innerCurrent;
                    if (duplicate.prev != null) {
                        duplicate.prev.next = duplicate.next;
                    }
                    if (duplicate.next != null) {
                        duplicate.next.prev = duplicate.prev;
                    }
                    if (duplicate.next == this.tail) {
                        this.tail = duplicate;
                    }
                    innerCurrent = duplicate.next;
                    this.size--;
                } else {
                    innerCurrent = innerCurrent.next;
                }
            }
            current = current.next;
        }
    }

    /*
     * public void addInOrder(E item) {
     * if (isEmpty()) {
     * this.head = this.tail = new Node<>(item, null, null);
     * } else {
     * if (item.compareTo(this.head.item) <= 0) {
     * addFirst(item);
     * } else if (item.compareTo(this.tail.item) > 0) {
     * addLast(item);
     * } else {
     * Node<E> current = this.tail;
     * while (current != null && item.compareTo(current.item) > 0) {
     * current = current.next;
     * }
     * Node<E> newNode = new Node<>(item, current, current.prev);
     * if (current.prev != null) {
     * current.prev.next = newNode;
     * }
     * current.prev = newNode;
     * if (current == this.head) {
     * this.head = newNode;
     * } else {
     * newNode.prev.next = newNode;
     * }
     * }
     * 
     * }
     * this.size++;
     * 
     * }
     */

    public E ultimoElemento() {
        if (this.size <= 0) {
            throw new IllegalStateException("vacio");
        }
        E element = this.tail.item;
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.head;
        while (current != null) {
            sb.append(current.item).append(" <->\n");
            current = current.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(head);
    }
}
