package utils.Queue;

public class SpeedQueue<E> {
    private final static Integer defaultDimension = 10;
    private E[] data;
    private int head;
    private int tail;

    /** Constructor sin parámetros (usa la dimensión por defecto) **/
    public SpeedQueue() {
        this(defaultDimension);
    }

    /** Constructor con dimensión específica **/
    @SuppressWarnings("unchecked")
    public SpeedQueue(int dimension) {
        this.data = (E[]) new Object[dimension + 1]; // Añade un espacio extra
        this.head = 0;
        this.tail = 0;
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
        return this.data[head];
    }

    /**
     * Método para devolver el primer elemento sin eliminarlo (no lanza excepción,
     * devuelve null)
     **/
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.data[this.head];
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
            return this.tail - this.head;
        } else {
            return this.data.length - this.head + this.tail;
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

// En este caso se opta por desperdiciar un espacio libre siempre en la
// implementación de la cola para distinguir fácilmente entre una cola llena y
// una vacía

// Es útil cuando la implementación debe ser fácil de entender y mantener, y
// cuando
// no se necesita la capacidad total del array. Este enfoque reduce la
// complejidad lógica a costa de perder un espacio.