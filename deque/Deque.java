package deque;

import java.util.Iterator;

public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public default boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public boolean equals(Object other);
    public Iterator<T> iterator();
}

