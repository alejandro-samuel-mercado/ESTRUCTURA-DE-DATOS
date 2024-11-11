package utils.List;

public interface ILinkedList<E> extends Iterable<E> {
    public int size();

    public void addFirst(E item);

    public void addLast(E item);

    public E removeFirst();

    public E removeLast();

}
