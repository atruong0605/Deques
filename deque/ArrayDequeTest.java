package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testing2() {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        LinkedListDeque<Integer> l = new LinkedListDeque<>();

        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);
        p.addLast(8);
        p.addLast(7);
        p.addLast(6);
        p.addLast(5);
        p.addLast(4);
        p.addLast(3);
        p.addLast(2);
        p.addLast(1);
        p.addLast(0);


        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);
        l.addLast(8);
        l.addLast(7);
        l.addLast(6);
        l.addLast(5);
        l.addLast(4);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
        l.addLast(0);


        assertTrue(p.equals(l));
    }

    @Test
    public void addIsEmptySizeTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addFirst(3);
        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* Tests the get(Iterative) method at a certain index */
    public void getTest() {
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        p.addFirst(3);
        p.addLast(4);
        p.addFirst(2);
        p.addLast(5);
        p.addFirst(1);
        p.addFirst(0);

        assertTrue(p.get(0).equals(0));
        assertTrue(p.get(1).equals(1));
        assertTrue(p.get(2).equals(2));
        assertTrue(p.get(3).equals(3));
        assertTrue(p.get(4).equals(4));
        assertTrue(p.get(5).equals(5));
    }

    public void testing() {
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        p.addFirst(0);
        p.addFirst(1);
        p.addFirst(2);
        p.addFirst(3);
        p.addFirst(4);
        p.addFirst(5);
        p.addFirst(6);
        p.addFirst(7);
        p.addFirst(8);
        p.addFirst(9);
        p.addFirst(10);
        p.addFirst(11);
        p.addFirst(12);
        p.addFirst(13);
        p.addFirst(14);
        p.addFirst(15);
        p.addFirst(16);
        p.addFirst(17);
        p.addFirst(18);
        p.addFirst(19);
        p.addFirst(20);
        p.addFirst(21);
        p.addFirst(22);
        p.addFirst(23);
        p.addFirst(24);
        p.addFirst(25);
        p.addFirst(26);
        p.addFirst(27);
        p.addFirst(28);
        p.addFirst(29);
        p.addFirst(30);
        p.addFirst(31);
        p.addFirst(32);
        p.addFirst(33);
        p.addFirst(34);
        p.addFirst(35);
        p.addFirst(36);
        p.addFirst(37);
        p.addFirst(38);
        p.addFirst(39);
        p.addFirst(40);
        p.addFirst(41);
        p.addFirst(42);
        p.addFirst(43);
        p.addFirst(44);
        p.addFirst(45);
        p.addFirst(46);
        p.addFirst(47);
        p.addFirst(48);
        p.addFirst(49);
        p.addFirst(50);
        p.addFirst(51);
        p.addFirst(52);
        p.addFirst(53);
        p.addFirst(54);
        p.addFirst(55);
        p.addFirst(56);
        p.addFirst(57);
        p.addFirst(58);
        p.addFirst(59);
        p.addFirst(60);
        p.addFirst(61);
        p.addFirst(62);
        p.addFirst(63);
        p.addFirst(64);
        p.addFirst(65);
        p.addFirst(66);
        p.addFirst(67);
        p.addFirst(68);
        p.addFirst(69);
        p.addFirst(70);
        p.addFirst(71);
        p.addFirst(72);
        p.addFirst(73);
        p.addFirst(74);
        p.addFirst(75);
        p.addFirst(76);
        p.addFirst(77);
        p.addFirst(78);
        p.addFirst(79);
        p.addFirst(80);
        p.addFirst(81);
        p.addFirst(82);
        p.addFirst(83);
        p.addFirst(84);
        p.addFirst(85);
        p.addFirst(86);
        p.addFirst(87);
        p.addFirst(88);
        p.addFirst(89);
        p.addFirst(90);
        p.addFirst(91);
        p.addFirst(92);
        p.addFirst(93);
        p.addFirst(94);
        p.addFirst(95);
        p.addFirst(96);
        p.addFirst(97);
        p.addFirst(98);
        p.addFirst(99);
        p.addFirst(100);
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();


    }

}
