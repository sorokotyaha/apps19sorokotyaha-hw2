package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class QueueTest {

    private Queue emptyQ;
    private Queue oneElemQ;
    private Queue lstQ;

    @Before
    public void setUp() {
        this.emptyQ = new Queue();
        this.oneElemQ = new Queue(new Object[]{1});
        this.lstQ = new Queue(new Object[]{1, 2, 3, 4, 5, 6, 7,});
    }


    @Test
    public void testpeek() {
        System.out.println("Testing peek with non empty Queue..");
        Object top = this.lstQ.peek();
        assertEquals(1, top);

        System.out.println("Testing peek with one element Queue..");
        Object top1 = this.oneElemQ.peek();
        assertEquals(1, top1);

        System.out.println("Testing peek with empty Queue..");
        Object top2 = this.emptyQ.peek();
        assertNull(top2);

    }

    @Test
    public void testDequeue() {
        System.out.println("Testing dequeue with non empty Queue..");
        Object top = this.lstQ.dequeue();
        assertEquals(1, top);
        assertArrayEquals(new Object[]{2, 3, 4, 5, 6, 7,}, this.lstQ.toArray());

        System.out.println("Testing dequeue with one element Queue..");
        Object top1 = this.oneElemQ.dequeue();
        assertEquals(1, top1);
        assertArrayEquals(new Object[0], this.oneElemQ.toArray());

        System.out.println("Testing dequeue with empty Queue..");
        Object top3 = this.emptyQ.dequeue();
        assertNull(top3);
        assertArrayEquals(new Object[0], this.emptyQ.toArray());

    }

    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue with non empty Queue..");
        this.lstQ.enqueue(0);
        assertEquals(1, this.lstQ.peek());

        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 0}, this.lstQ.toArray());

        System.out.println("Testing enqueue with one element Queue..");
        this.oneElemQ.enqueue(0);
        assertEquals(1, this.lstQ.peek());
        assertArrayEquals(new Object[]{1, 0}, this.oneElemQ.toArray());

        System.out.println("Testing enqueue with empty Queue..");
        this.emptyQ.enqueue(0);
        assertArrayEquals(new Object[]{0}, this.emptyQ.toArray());

    }

    @Test
    public void testGetSize() {
        System.out.println("Testing getSize with non empty Queue..");
        assertEquals(7, this.lstQ.getSize());

        System.out.println("Testing getSize with one element Queue..");
        assertEquals(1, this.oneElemQ.getSize());

        System.out.println("Testing getSize with empty Queue..");
        assertEquals(0, this.emptyQ.getSize());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty with Queue..");
        assertTrue(this.emptyQ.isEmpty());
        assertFalse(this.oneElemQ.isEmpty());
        assertFalse(this.lstQ.isEmpty());

    }

    @Test
    public void testToArray() {
        System.out.println("Testing toArray with non empty Queue..");
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7}, this.lstQ.toArray());

        System.out.println("Testing toArray with one element Queue..");
        assertArrayEquals(new Object[]{1}, this.oneElemQ.toArray());

        System.out.println("Testing toArray with empty Queue..");
        assertArrayEquals(new Object[0], this.emptyQ.toArray());

    }
}
