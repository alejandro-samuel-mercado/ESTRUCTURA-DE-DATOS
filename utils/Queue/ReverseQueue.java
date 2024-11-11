package utils.Queue;

public class ReverseQueue<E> {
    private static final int defaultDimension = 100;
    private int head;
    private int tail;
    private int count;
    private E[] data;

    public ReverseQueue() {
        this(defaultDimension);
    }

    @SuppressWarnings("unchecked")
    public ReverseQueue(int dimension) {
        this.data = (E[]) new Object[dimension];
        this.count = 0;
        this.head = dimension - 1;
        this.tail = dimension - 1;
    }

    public int next(int pos) {
        pos--;
        if (pos < 0) {
            pos = data.length - 1;
        }
        return pos;
    }

    public boolean add(E element) {
        if (isFull()) {
            throw new RuntimeException("Cola llena");
        }
        this.data[this.tail] = element;
        this.tail = next(this.tail);
        this.count++;
        return true;
    }

    public boolean offer(E element) {
        if (isFull()) {
            return false;
        }
        this.data[this.tail] = element;
        this.tail = next(this.tail);
        this.count++;
        return true;
    }

    public E element() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        E element = this.data[this.head];
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E element = this.data[this.head];
        return element;
    }

    public E remove() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        E element = this.data[this.head];
        this.head = next(this.head);
        this.count--;
        return element;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E element = this.data[this.head];
        this.head = next(this.head);
        this.count--;
        return element;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public boolean isFull() {
        return this.count >= data.length;
    }
}
