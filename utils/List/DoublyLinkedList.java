package utils.List;

import java.util.Iterator;

/**
 * DoubleLinkedList
 */
public class DoublyLinkedList<E extends Comparable<E>> implements ILinkedList<E> {

    private Node<E> head; // Inicio
    private Node<E> tail; // Fin
    private int size; // Tamaño de la lista

    // Constructor de la lista enlazada
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<E> getHead() {
        return this.head;
    }

    /** Agregar un elemento al principio de la lista */
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, null, null); // Crear un nuevo nodo
        if (isEmpty()) {
            this.head = this.tail = newNode; // Si la lista está vacía, head y tail son el nuevo nodo
        } else {
            newNode.next = this.head;
            this.head.prev = newNode; // Establecer el anterior del head actual
            this.head = newNode; // Actualizar head
        }
        this.size++; // Incrementar el tamaño
    }

    /** Agregar un elemento al final de la lista */
    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null, null); // Crear un nuevo nodo

        if (isEmpty()) {
            this.head = this.tail = newNode; // Si la lista está vacía, head y tail son el nuevo nodo
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode; // Conectar el nodo actual tail al nuevo nodo
            this.tail = newNode; // Actualizar tail
        }
        this.size++; // Incrementar el tamaño
    }

    /**
     * Asegura que el nuevo nodo se inserte correctamente al principio de la lista
     * enlazada,
     * manteniendo la integridad de las referencias de nodos adyacentes.
     **/
    public void betterAddFirst(E item) {
        Node<E> newNode = new Node<>(item, this.head, null); // Crear un nuevo nodo
        if (isEmpty()) {
            this.tail = newNode; // Si la lista está vacía, head y tail son el nuevo nodo
        } else {
            this.head.prev = newNode; // Establecer el anterior del head actual
        }
        this.head = newNode; // Actualizar head
        this.size++; // Incrementar el tamaño
    }

    public void betterAddLast(E item) {
        Node<E> newNode = new Node<>(item, null, this.tail); // Crear un nuevo nodo
        if (isEmpty()) {
            this.head = newNode; // Si la lista está vacía, head y tail son el nuevo nodo
        } else {
            this.tail.next = newNode; // Conectar el nodo actual tail al nuevo nodo }
        }
        this.tail = newNode; // Actualizar tail
        this.size++; // Incrementar el tamaño

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
                current = current.next; // Avanzar hasta la posición deseada
            }
            Node<E> newNode = new Node<>(item, current, current.prev);
            if (current.prev != null) {
                current.prev.next = newNode; // Conectar el nodo anterior con el nuevo nodo
            }
            current.prev = newNode; // Conectar el nuevo nodo con el nodo actual
            this.size++;
        }

    }

    /** Eliminar el primer elemento de la lista */
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        E item = this.head.item; // Obtener el elemento
        if (this.head == this.tail) { // Si la lista se queda vacía
            this.tail = this.head = null; // También establecer tail a null
        } else {
            this.head = this.head.next;
            this.head.prev = null; // Limpiar la referencia anterior del nuevo head
        }
        this.size--; // Decrementar el tamaño
        return item; // Retornar el elemento eliminado
    }

    /** Eliminar el último elemento de la lista */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }

        E item = this.tail.item; // Guardar el elemento a eliminar

        if (this.head == this.tail) { // Si solo hay un elemento, también se usa if(this.head.next==null)
            this.head = this.tail = null; // Limpiar la lista
        } else {
            this.tail = this.tail.prev; // Actualizar tail al nodo anterior
            this.tail.next = null; // Desconectar el último nodo
        }
        this.size--; // Decrementar el tamaño
        return item; // Retornar el elemento eliminado
    }

    /** Eliminar un elemento en específico */
    public void remove(E element) {
        if (isEmpty()) {
            return; // No hay nada que eliminar
        }

        if (this.head.item.equals(element)) { // Si el elemento es el primero
            removeFirst();
            return;
        }

        else if (this.tail.item.equals(element)) { // Si el elemento es el primero
            removeLast();
            return;
        } else {
            Node<E> current = this.head; // Comenzar desde head
            while (current != null) {
                if (current.item.equals(element)) { // Si encontramos el elemento
                    if (current.prev != null) {
                        current.prev.next = current.next; // Desconectar el nodo
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev; // Desconectar el nodo
                    }
                    if (current == this.tail) { // Si eliminamos el tail
                        this.tail = current.prev; // Actualizar tail
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
        Node<E> node = this.head;
        E element = null;
        if (index >= 0 && index < this.size) {
            for (int i = 0; i < this.size && i != index; i++) {
                node = node.next;
            }
            element = node.item;
        }
        return element;
    }

    /** Borrar todos los elementos **/
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Eliminar duplicados **/
    public void removeDuplicate() {
        Node<E> current = head;

        while (current != null) { // Recorrer la lista con el primer puntero
            Node<E> innerCurrent = current.next;

            // Recorrer la lista con el segundo puntero para encontrar duplicados
            while (innerCurrent.next != null) {
                if (current.item.equals(innerCurrent.item)) {
                    Node<E> duplicate = innerCurrent; // Eliminar el nodo duplicado

                    // Actualizar referencias del nodo anterior y siguiente
                    if (duplicate.prev != null) {
                        duplicate.prev.next = duplicate.next;
                    }
                    if (duplicate.next != null) {
                        duplicate.next.prev = duplicate.prev;
                    }

                    if (duplicate == tail) {
                        tail = duplicate.prev; // Si el nodo duplicado es tail, actualizamos tail
                    }

                    // Avanzamos el puntero "innerCurrent" después de eliminar
                    innerCurrent = duplicate.next;

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
     * 
     */
    public void AddInOrder(E item) {
        // Si la lista está vacía, agrega el nuevo nodo como head y tail
        if (this.size == 0) {
            this.head = this.tail = new Node<>(item, null, null);
        } else {
            // Si el elemento es menor o igual al elemento en la cabeza, agregar al
            // principio
            if (item.compareTo(this.head.item) <= 0) {
                this.addFirst(item);
            }
            // Si el elemento es mayor que el último elemento, agregar al final
            else if (item.compareTo(this.tail.item) > 0) {
                this.addLast(item);
            }
            // Si el elemento debe estar en algún punto intermedio
            else {
                Node<E> current = this.head;
                // Recorrer la lista para encontrar la posición correcta
                while (current != null && item.compareTo(current.item) > 0) {
                    current = current.next;
                }
                // Insertar el nuevo nodo antes del nodo encontrado
                Node<E> newNode = new Node<>(item, current, current.prev);
                if (current.prev != null) {
                    current.prev.next = newNode; // Conectar el nodo anterior con el nuevo nodo
                }
                current.prev = newNode; // Conectar el nuevo nodo con el nodo actual
                if (current == this.head) {
                    this.head = newNode; // Actualizar head si es necesario

                } else {
                    // Asegurar que el nodo previo a current se conecta al nuevo nodo
                    newNode.prev.next = newNode;
                }
            }
        }

        this.size++;

    }

    /** Verificar si la lista está vacía */
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Representación de la lista como una cadena */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = this.head;
        while (current != null) {
            sb.append(current.item).append(" <->\n");
            current = current.next;
        }
        return sb.toString();
    }

    public void mostrar() {
        System.out.println(toString());
    }

    // Método para recorrer la lista de cabeza a cola
    public void travelNext() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.item + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Método para recorrer la lista de cola a cabeza
    public void travelBack() {
        Node<E> current = tail;
        while (current != null) {
            System.out.print(current.item + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    /** Implementación del iterador */
    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator<>(head);
    }

    public E ultimoElemento(){
        if(this.size<=0){
            throw new IllegalStateException("vacio");
        }
        E element=this.tail.item;
        return element;
    }

}