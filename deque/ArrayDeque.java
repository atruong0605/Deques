package deque;

import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size = 0;

    private static final int FOUR = 4;
    private static final int SIXTEEN = 16;
    private static final int INT_FIRST = 3;
    private static final int INT_LAST = 4;
    private int nextFirst = INT_FIRST;
    private int nextLast = INT_LAST;
    private static final int STARTING = 8;

    /**
     * Creates an empty array with size 8
     */
    public ArrayDeque() {
        items = (T[]) new Object[STARTING];
    }

    /**
     * Returns the size of the deque
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Adds an item to the front of the deque
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length && nextLast > nextFirst) {
            resizeUp(size * 2);
            nextFirst = items.length - (size - nextFirst);
        } else if (size == items.length) {
            resizeUp(size * 2);
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    /**
     * Removes the item at the front of the deque and returns it
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T first = items[(nextFirst + 1) % items.length];
            nextFirst = (nextFirst + 1) % items.length;
            size -= 1;
            if (items.length / FOUR == size && items.length > SIXTEEN && nextFirst > nextLast) {
                resizeDown(items.length / 2);
                nextFirst = nextFirst - items.length;
                nextLast = size;
            } else if (items.length / FOUR == size && items.length > SIXTEEN) {
                resizeDown(items.length / 2);
                nextFirst = items.length - 1;
                nextLast = size;
            }
            return first;
        }
    }


    /**
     * Adds an item to the back of the deque
     */
    @Override
    public void addLast(T item) {
        if (size == items.length && nextLast > nextFirst) {
            int holder = items.length - nextFirst;
            resizeUp(size * 2);
            nextFirst = items.length - holder;
        } else if (size == items.length) {
            resizeUp(size * 2);
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    /**
     * Remove the item at the end of the deque and returns it
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (nextLast == 0) {
            T last = items[items.length - 1];
            nextLast = items.length - 1;
            size -= 1;
            if (items.length / FOUR == size && items.length > SIXTEEN) {
                resizeDown(items.length / 2);
                nextFirst = items.length - 1;
                nextLast = size;
            }
            return last;
        } else {
            T last = items[(nextLast - 1) % items.length];
            nextLast = (nextLast - 1) % items.length;
            size -= 1;
            if (items.length / FOUR == size && items.length > SIXTEEN) {
                resizeDown(items.length / 2);
                nextFirst = items.length - 1;
                nextLast = size;
            }
            return last;
        }
    }


    /**
     * Gets the item at the given index
     */
    @Override
    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }

    /**
     * Prints the items in the deque from first to last
     */
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
        }
    }

    /**
     * Resizes the array up with the given capacity
     */
    private void resizeUp(int capacity) {
        T[] newSize = (T[]) new Object[capacity];
        if (nextLast > nextFirst) {
            System.arraycopy(items, 0, newSize, 0, nextLast);
            int x = nextFirst + 1;
            int y = newSize.length - (size - nextFirst - 1);
            int z = size - nextFirst - 1;
            System.arraycopy(items, x, newSize, y, z);
        } else {
            System.arraycopy(items, 0, newSize, 0, size);
        }
        items = newSize;
    }

    /**
     * Resizes the array down with the given capacity
     */
    private void resizeDown(int capacity) {
        T[] newSize = (T[]) new Object[capacity];
        if (nextLast < nextFirst) {
            System.arraycopy(items, 0, newSize, 0, nextLast);
            int x = nextFirst + 1;
            int y = nextFirst - newSize.length + 1;
            int z = items.length - nextFirst - 1;
            System.arraycopy(items, x, newSize, y, z);
        } else {
            System.arraycopy(items, nextFirst + 1, newSize, 0, nextLast - nextFirst - 1);
        }
        items = newSize;
    }

    /**
     * Returns an Iterator of the ArrayDeque class
     */
    public Iterator<T> iterator() {
        return new ArrayDeque.ArrayDequeIterator();
    }


    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos = nextFirst;

        public boolean hasNext() {
            return wizPos + 1 != nextLast;
        }

        public T next() {
            wizPos = (wizPos + 1) % items.length;
            return items[wizPos];
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
        if (other instanceof ArrayDeque<?>) {
            ArrayDeque<T> o = (ArrayDeque<T>) other;
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
        return false;
    }

}

