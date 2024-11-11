package TP3;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private final int maxSize = 100;
    private T[] data;
    private int count;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        data = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        this.data = (T[]) new Object[maxSize];
        this.count = 0;
    }

    public T push(T element) {
        if (this.size() >= this.data.length) {
            throw new RuntimeException("La pila está llena");
        }
        this.data[this.count] = element;
        ++this.count;
        return element;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("La Pila está vacía");
        }
        T element = this.data[this.count - 1];
        --this.count;
        return element;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila está llena");
        }
        T element = this.data[this.count - 1];
        return element;
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    // Método para obtener el tamaño actual de la pila
    public int size() {
        return this.count;
    }

    // Implementación de Iterable para permitir el uso de for-each
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = count - 1; // Iterar desde el último elemento

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return data[index--];
            }
        };
    }
}
