package utils.List;

import java.util.Iterator;

public class SingleLinkedLista<E extends Comparable<E>> implements ILinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedLista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<E>(item, null);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void betterAddFirst(E item) {
        Node<E> newNode = new Node<E>(item, this.head);
        if (isEmpty()) {
            this.tail = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void betterAddLast(E item) {
        Node<E> newNode = new Node<>(item, null);
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
            throw new IllegalStateException("Vacía");
        }
        E element = this.head.item;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.size--;
        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Vacía");
        }
        E element = this.head.item;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            Node<E> current = this.head;
            while (current.next != tail) {
                current = current.next;
            }
            this.tail = current;
            this.tail.next = null;
        }
        this.size--;
        return element;
    }

    public E element() {
        if (isEmpty()) {
            throw new IllegalStateException("vacía");
        }
        E element = this.head.item;
        return element;
    }

    public void clear() {
        this.tail = null;
        this.head = null;
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

    public E get(int index) {
        Node<E> current = this.head;
        E element = null;
        if (0 <= index && index < this.size) {
            for (int i = 0; i < this.size && i != index; i++) {
                current = current.next;
            }
            element = current.item;

        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return element;
    }

    public void addAtPosition(int pos, E item) {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException("fuera");
        }
        if (pos == 0) {
            addFirst(item);
        } else if (pos == this.size) {
            addLast(item);
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(item, current.next);
            current.next = newNode;
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
                    current.next = current.next.next;
                    if (current.next == null) {
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
            throw new IllegalStateException("vacía");
        }
        Node<E> current = this.head;
        while (current != null) {
            Node<E> innerCurrent = current;
            while (innerCurrent.next != null) {
                if (current.item.equals(innerCurrent.next.item)) {
                    innerCurrent.next = innerCurrent.next.next;
                    this.size--;
                }
                innerCurrent = innerCurrent.next;
            }
            current = current.next;
        }
    }

    public void addInOrder(E item) {
        if (isEmpty()) {
            this.head = this.tail = new Node<>(item, null);
        } else {
            if (item.compareTo(this.head.item) <= 0) {
                addFirst(item);
            } else if (item.compareTo(this.tail.item) > 0) {
                addLast(item);
            } else {
                Node<E> current = this.head;
                while (current != null && (item.compareTo(current.item) > 0)) {
                    current = current.next;
                }
                Node<E> newNode = new Node<>(item, current, current.prev);
                if (current != null) {
                    current.next = newNode;
                }
                if (current != this.head) {
                    Node<E> prev = this.head;
                    while (prev.next != current) {
                        prev = prev.next;
                    }
                    prev.next = newNode;
                }
            }
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(head);

    }
}
