package TP3.Punto1;

public class Stack<T> {
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

    public T get(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return this.data[index];
    }

    public boolean exist(T element) {
        boolean yaEsta = false;

        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)) {
                yaEsta = true;
                break;
            }
        }
        return yaEsta;

    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    // Método para obtener el tamaño actual de la pila
    public int size() {
        return this.count;
    }

}
