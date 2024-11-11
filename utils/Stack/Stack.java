package utils.Stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private final int maxSize = 100;
    private T[] data;
    private int count;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.data = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        this.data = (T[]) new Object[maxSize];
        this.count = 0;
    }

    /** Método para añadir un elemento al final **/
    public void push(T element) {
        if (size() >= this.data.length) {
            throw new RuntimeException("La pila está llena");
        }
        this.data[this.count] = element;
        ++this.count;
    }

    /** Método para eliminar el elemento del final **/
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La Pila está vacía");
        }
        T element = this.data[this.count - 1];
        --this.count;
        return element;
    }

    /** Método para devolver el elemento del final **/
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila está llena");
        }
        T element = this.data[this.count - 1];
        return element;
    }

    /** Método para buscar un elemento **/

    public Integer search(T element) {
        for (int pos = size() - 1; pos >= 0; --pos) {
            if (this.data[pos].equals(element)) {
                return data.length - pos;
            }
        }
        return -1;
    }

    /** Método para verificar si la cola está vacía **/
    public boolean isEmpty() {
        return this.count <= 0;
    }

    /** Método para obtener el tamaño actual **/
    public int size() {
        return this.count;
    }

    /** Método para verificar si la pila está llena **/
    public boolean isFull() {
        return this.size() >= this.data.length;
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
