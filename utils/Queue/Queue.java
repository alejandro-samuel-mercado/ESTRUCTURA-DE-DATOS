package utils.Queue;

import java.util.Iterator;

public class Queue<E> implements Iterable<E> {
    private final static Integer defaultDimension = 10;
    private E[] data;
    private int head;
    private int tail;
    private int count;

    /** Constructor sin parámetros (usa la dimensión por defecto) **/
    public Queue() {
        this(defaultDimension);
    }

    /** Constructor con dimensión específica **/
    @SuppressWarnings("unchecked")
    public Queue(int dimension) {
        this.data = (E[]) new Object[dimension]; // Inicializa el array
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /** Método para obtener la posición siguiente de un elemento de la cola **/
    private int next(int pos) {
        pos++;
        if (pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }

    /** Método para añadir un elemento al final la cola **/
    public void add(E element) {
        if (isFull()) {
            throw new IllegalStateException("Cola llena");
        }
        this.data[this.tail] = element; // Añade el elemento a donde apunta el tail. Tambien podria apuntar al contador
        this.tail = this.next(this.tail); // Ahora el tail apunta a la siguiente posición
        ++this.count;

    }

    /**
     * Método para añadir un elemento al final sin lanzar excepción en caso de error
     **/
    public boolean offer(E element) {
        if (isFull()) {
            return false;
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    /**
     * Método para devolver el primer elemento sin eliminarlo (lanza excepción si
     * está vacía)
     **/
    public E element() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return this.data[this.head];
    }

    /**
     * Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
     * devuelve null)
     **/
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.data[this.head];
    }

    /**
     * Método para eliminar y devolver el primer elemento (lanza excepción si
     * está vacía)
     **/
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        E element = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return element;
    }

    /**
     * Método para eliminar y devolver el primer elemento (retorna null si está
     * vacía)
     **/
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E element = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return element;
    }

    /** Método para obtener el tamaño actual de la cola **/
    public int size() {
        return this.count;
    }

    /** Método para verificar si la cola está vacía **/
    public boolean isEmpty() {
        return this.size() <= 0;
    }

    /** Método para verificar si la cola está llena **/
    public boolean isFull() {
        return this.size() >= this.data.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = count - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return data[index--];
            }
        };
    }

}

/// --------------------------
// En este caso se hace uso de un contador,la cual utiliza memoria adicional y
/// requiere de un trabajo adicional al ser actualizado cada vez que se realiza
/// una operación de inserción o eliminación

// Es útil cuando se quiere aprovechar al máximo el espacio disponible en la
// cola y se está dispuesto a gestionar una variable adicional para contar los
// elementos. Esto es especialmente útil cuando el uso del espacio es una
// prioridad y se desea una capacidad total de N elementos.