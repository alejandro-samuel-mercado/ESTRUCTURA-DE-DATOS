package utils.Stack;

public class ReverseStack<T> implements Iterable<T> {
    private final int maxSize = 100;
    private T[] data;
    private int count;

    @SuppressWarnings("unchecked")
    public ReverseStack(int size) {
        this.data = (T[]) new Object[size];
        this.count = 0;
    }

    @SuppressWarnings("unchecked")
    public ReverseStack() {
        this.data = (T[]) new Object[maxSize];
        this.count = 0;
    }

    /** Método para añadir un elemento al inicio **/
    public T push(T element) {
        if (isFull()) {
            throw new RuntimeException("La pila está llena");
        }
        // Desplazar elementos a la derecha
        for (int i = count; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }
        // Insertar el nuevo elemento en la posición 0
        this.data[0] = element;
        ++this.count;
        return element;
    }

    /** Método para eliminar el elemento del inicio **/
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La Pila está vacía");
        }
        // Obtener el elemento en la posición 0
        T element = this.data[0];
        // Desplazar los elementos a la izquierda
        for (int i = 0; i < count - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        --this.count;
        return element;
    }

    /** Método para devolver el elemento del inicio **/
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return this.data[0];
    }

    /** Método para buscar un elemento **/
    public Integer search(T element) {
        for (int pos = 0; pos < size(); ++pos) {
            if (this.data[pos].equals(element)) {
                return pos;
            }
        }
        return -1;
    }

    /** Método para verificar si la pila está vacía **/
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

    /** Implementación del iterador (opcional) **/
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count;
            }

            @Override
            public T next() {
                return data[currentIndex++];
            }
        };
    }
}
