package gh2;


import deque.ArrayDeque;
import deque.Deque;

import static java.lang.Math.round;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int bufferNumber = (int) round(SR / frequency);
        buffer = new ArrayDeque<>();
        while (bufferNumber > 0) {
            buffer.addLast(0.0);
            bufferNumber -= 1;
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        int sizeCounter = 0;
        int bufferSize = buffer.size();
        int bufferSize2 = buffer.size();
        while (bufferSize > 0) {
            buffer.removeFirst();
            bufferSize -= 1;
        }
        while (sizeCounter != bufferSize2) {
            double r = Math.random() - 0.5;
            buffer.addLast(r);
            sizeCounter += 1;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double first = buffer.get(0);
        double second = buffer.get(1);
        double newDouble = DECAY * ((first + second) / 2);
        buffer.addLast(newDouble);
        buffer.removeFirst();
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}

