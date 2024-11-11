package TP5.Punto1;

import java.util.Comparator;
import java.util.Iterator;

/**
 * SingleLinkedList
 */
public class SingleLinkedList<E> implements ILinkedList<E> {

    private Node<E> head; // Inicio
    private Node<E> tail; // Fin
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /** Agregar un elemento al principio de la lista */
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, null); // Se crea un nodo con el elemento a agregar
        if (isEmpty()) {
            this.head = this.tail = newNode; // El nuevo nodo es el primero y el último
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Asegura que el nuevo nodo se inserte correctamente al principio de la lista
     * enlazada,
     * manteniendo la integridad de las referencias de nodos adyacentes.
     **/
    public void betterAddFirst(E item) {
        Node<E> newNode = new Node<>(item, this.head);// Se crea un nodo con el elemento a agregar
        if (isEmpty()) {
            this.tail = newNode; // El nuevo nodo es el único elemento y, por lo tanto, también el último
        }
        this.head = newNode; // Actualizar head
        this.size++;
    }

    /** Agregar un elemento al final de la lista */
    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next; // o this.tail= newNode;
        }
        this.size++;
    }

    public void betterAddLast(E item) {
        Node<E> newNode = new Node<>(item, null);// Se crea un nodo con el elemento a agregar
        if (isEmpty()) {
            this.head = newNode; // El nuevo nodo es el único elemento y, por lo tanto, también el último
        } else {
            this.tail.next = newNode; // Establecer el nodo anterior del actual head
        }
        this.tail = newNode;
        this.size++;
    }

    /** Agregar un elemento en una posición específica **/
    public void addAtPosition(int position, E item) {
        if (position < 0 || position > this.size) {
            throw new IndexOutOfBoundsException("Posición no válida");
        }
        if (position == 0) {
            this.addFirst(item);
        } else if (position == this.size) {
            this.addLast(item);
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next; // Avanzar al nodo anterior a la posición deseada
            }
            Node<E> newNode = new Node<>(item, current.next);
            current.next = newNode; // Conectar el nodo anterior con el nuevo nodo
            this.size++;
        }

    }

    /** Eliminar el primer elemento de la lista */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E item = this.head.item; // Toma el elemento que está en el primer nodo
        if (this.head == this.tail) { // Si solo hay un elemento
            this.head = this.tail = null;
        } else {
            this.head = this.head.next; // Avanza el primer nodo al siguiente
        }
        this.size--;
        return item;
    }

    /** Eliminar el último elemento de la lista */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }

        E item = this.tail.item; // Toma el elemento que está en el último nodo
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            Node<E> current = this.head;
            while (current.next != tail) { // Encontrar el penúltimo nodo
                current = current.next;
            }
            this.tail = current; // Actualiza tail al penúltimo nodo
            this.tail.next = null; // Anula la referencia al siguente nodo
        }
        this.size--;
        return item;
    }

    /** Eliminar un elemento en específico */
    public void remove(E element) {
        if (isEmpty()) {
            return; // No hay nada que eliminar
        }

        if (this.head.item.equals(element)) { // Si el elemento es el primero
            removeFirst();
            return;
        } else if (this.tail.item.equals(element)) {// Si el elemento es el último
            removeLast();
            return;

        } else {
            Node<E> current = this.head; // Comenzar desde head
            while (current.next != null) {
                if (current.next.item.equals(element)) { // Si encontramos el elemento
                    current.next = current.next.next; // Desconectar el nodo
                    if (current.next == null) { // Si eliminamos el tail
                        this.tail = current; // Actualizar tail
                    }
                    this.size--; // Decrementar tamaño
                    return;
                }
                current = current.next; // Continuar con el siguiente nodo
            }
        }
    }

    /** Devuelve el primer elemento sin eliminarlo **/
    public E element() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E item = this.head.item;// Guardar el elemento a eliminar
        return item; // Retornar el elemento eliminado
    }

    /** Devolver elemento en una posición determinada **/
    public E get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        Node<E> current = this.head;
        E element = null;
        if (index >= 0 && index < this.size) {
            for (int i = 0; i < this.size && i != index; i++) {
                current = current.next;
            }
            element = current.item;

        } else {
            throw new IndexOutOfBoundsException("Indice no válido");
        }
        return element;
    }

    /** Borrar todos los elementos **/
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Eliminar elementos duplicados **/
    public void removeDuplicate() {
        Node<E> current = this.head;

        // Recorrer la lista con el primer puntero
        while (current != null) {
            Node<E> innerCurrent = current;
            // Recorrer la lista con el segundo puntero para encontrar duplicados
            while (innerCurrent.next != null) {
                if (current.item.equals(innerCurrent.next.item)) {
                    // Eliminar el nodo duplicado saltándolo
                    innerCurrent.next = innerCurrent.next.next;
                    size--;
                } else {
                    innerCurrent = innerCurrent.next;
                }
            }
            current = current.next;
        }
    }

    /** Verificar si contiene un elemento específico **/
    public boolean contains(E element) {
        Node<E> current = this.head;
        while (current != null) {
            if (current.item.equals(element)) {
                return true; // Elemento encontrado
            }
            current = current.next;
        }
        return false; // Elemento no encontrado
    }

    /**
     * Sirve para insertar un elemento en la lista manteniendo el
     * orden ascendente o descendente de los elementos.
     **/

    public void AddInOrder(E item, Comparator<? super E> compareTo) {
        // Si la lista está vacía, agrega el nuevo nodo como head y tail
        if (isEmpty()) {
            this.head = this.tail = new Node<>(item, null);
        } else {
            // Si el elemento es menor o igual al elemento en la cabeza, agregar al
            // principio
            if (compareTo.compare(item, this.head.item) <= 0) {
                this.addFirst(item);
            }
            // Si el elemento es mayor que el último elemento, agregar al final
            else if (compareTo.compare(item, this.tail.item) > 0) {
                this.addLast(item);
            }
            // Si el elemento debe estar en algún punto intermedio
            else {
                Node<E> current = this.head;
                // Recorrer la lista para encontrar la posición correcta
                while (current != null && compareTo.compare(item, current.item) > 0) {
                    current = current.next;
                }
                // Insertar el nuevo nodo antes del nodo encontrado
                Node<E> newNode = new Node<>(item, current);
                if (current != null) {
                    // Si no estamos insertando al principio
                    newNode.next = current; // Conectar el nuevo nodo con el nodo actual
                }
                // Conectar el nuevo nodo con el nodo anterior
                if (current != this.head) {
                    Node<E> prev = this.head;
                    while (prev.next != current) {
                        prev = prev.next; // Encontrar el nodo anterior
                    }
                    prev.next = newNode; // Conectar el nodo anterior con el nuevo nodo
                }
            }
        }

        this.size++;
    }

    /** Verificar si la lista está vacía */
    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    /** Representación de la lista como una cadena */
    @Override
    public String toString() {

        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.head;
        while (current != null) {
            sb.append(current.item).append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    public void mostrar() {
        System.out.println(toString());
    }

    /** Obtener el primer elemento **/
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return this.head.item;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return this.tail.item;
    }

    /** Implementación del iterador */
    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(head);
    }
}