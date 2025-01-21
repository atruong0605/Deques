package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    /**
     * Creates a MaxArrayDeque with the given Comparator
     */
    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    /**
     * Returns the maximum element in the deque governed by the previously given Comparator
     */
    public T max() {
        T max = get(0);
        if (this.size() <= 0) {
            return null;
        }
        for (int i = 1; i < this.size(); i++) {
            if (comp.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }

    /**
     * Returns the maximum element in the deque governed by the parameter
     */
    public T max(Comparator<T> c) {
        Comparator<T> newComp = c;
        T max = get(0);
        if (this.size() <= 0) {
            return null;
        }
        for (int i = 1; i < this.size(); i++) {
            if (newComp.compare(get(i), max) > 0) {
                max = get(i);
            }
        }
        return max;
    }
}
