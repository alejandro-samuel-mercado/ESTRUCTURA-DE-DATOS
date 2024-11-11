package utils.Queue;

public class ReverseSpeedQueue<E> {
    private final static Integer defaultDimension = 10;
    private E[] data;
    private int head;
    private int tail;

    /** Constructor sin parámetros (usa la dimensión por defecto) **/
    public ReverseSpeedQueue() {
        this(defaultDimension);
        this.head = this.data.length - 1;
        this.tail = this.data.length - 1;
    }

    /** Constructor con dimensión específica **/
    @SuppressWarnings("unchecked")
    public ReverseSpeedQueue(int dimension) {
        this.data = (E[]) new Object[dimension + 1]; // Añade un espacio extra
        this.head = dimension;
        this.tail = dimension;
    }

    /** Método para obtener la posición siguiente de un elemento de la cola **/
    private int next(int pos) {
        pos--;
        if (pos < 0) {
            pos = this.data.length - 1;
        }
        return pos;
    }

    /** Método para añadir un elemento al final la cola **/
    public void add(E element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cola llena");

        }
        this.data[this.tail] = element; // Añade el elemento a donde apunta el tail
        this.tail = this.next(this.tail); // Ahora el tail apunta a la siguiente posición
    }

    /**
     * Método para añadir un elemento al final sin lanzar excepción en caso de error
     **/
    public boolean offer(E element) {
        if (this.isFull()) {
            return false;
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        return true;
    }

    /**
     * Método para devolver el primer elemento sin eliminarlo (lanza excepción si
     * está vacía)
     **/
    public E element() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        E element = this.data[this.head];
        return element;
    }

    /**
     * Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
     * devuelve null)
     **/
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E element = this.data[this.head];
        return element;
    }

    /**
     * Método para eliminar y devolver el primer elemento (lanza excepción si
     * está vacía)
     **/
    public E remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        E element = this.data[this.head];
        this.head = this.next(this.head);
        return element;
    }

    /**
     * Método para eliminar y devolver el primer elemento (retorna null si está
     * vacía)
     **/
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        E element = this.data[this.head];
        this.head = this.next(this.head);
        return element;
    }

    /** Método para obtener el tamaño actual de la cola **/
    public int size() {
        if (this.tail >= this.head) {
            return this.data.length - this.tail + this.head;
        } else {
            return this.head - this.tail;
        }
    }

    /** Método para verificar si la cola está vacía **/
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    /** Método para verificar si la cola está llena **/
    public boolean isFull() {
        return this.next(this.tail) == this.head;
    }
}
