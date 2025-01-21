package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class TNode {
        private T item;
        private TNode next;
        private TNode previous;

        public TNode(TNode p, T i, TNode n) {
            previous = p;
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size = 0;

    /**
     * Creates an empty linked list deque
     */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    /**
     * Returns the size of the LinkedList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds an item of type T in front of the deque
     */
    @Override
    public void addFirst(T item) {
        TNode first = new TNode(sentinel, item, sentinel.next);
        sentinel.next = first;
        sentinel.next.next.previous = sentinel.next;
        size += 1;
    }

    /**
     * Removes and returns the item at the front of the deque
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T first = sentinel.next.item;
            sentinel.next.next.previous = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return first;
        }
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    @Override
    public void addLast(T item) {
        TNode last = new TNode(sentinel.previous, item, sentinel);
        sentinel.previous = last;
        sentinel.previous.previous.next = sentinel.previous;
        size += 1;
    }

    /**
     * Removes and returns the item at the back of the deque
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = sentinel.previous.item;
            sentinel.previous.previous.next = sentinel;
            sentinel.previous = sentinel.previous.previous;
            size -= 1;
            return last;
        }
    }

    /**
     * Gets the item at the given index (Iterative)
     */
    @Override
    public T get(int index) {
        TNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                return p.item;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * Gets the item at the given index (Recursive)
     */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    /**
     * getRecursiveHelper function keeps track of the nodes
     */
    private T getRecursiveHelper(int index, TNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        TNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * Returns an Iterator of the LinkedListDeque class
     */
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private TNode temp = sentinel;

        public boolean hasNext() {
            if (temp.next == sentinel) {
                return false;
            }
            return true;
        }

        public T next() {
            temp = temp.next;
            return temp.item;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other instanceof Deque<?>) {
            Deque<T> o = (Deque<T>) other;
            if (o.size() != this.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                if (!o.get(i).equals(this.get(i))) {
                    return false;
                }
            }
            return true;
        }
        if (other instanceof LinkedListDeque<?>) {
            LinkedListDeque<T> o = (LinkedListDeque<T>) other;
            if (o.size() != this.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                if (!o.get(i).equals(this.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
