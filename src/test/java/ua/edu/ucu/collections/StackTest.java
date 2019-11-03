package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack emptyS;
    private Stack oneElemS;
    private Stack lstS;

    @Before
    public void setUp() {
        this.emptyS = new Stack();
        this.oneElemS = new Stack(new Object[]{1});
        this.lstS = new Stack(new Object[]{1, 2, 3, 4, 5, 6, 7,});
    }


    @Test
    public void getSize() {
        System.out.println("Testing getSize with non empty Stack..");
        assertEquals(7, this.lstS.getSize());

        System.out.println("Testing getSize with one element Stack..");
        assertEquals(1, this.oneElemS.getSize());

        System.out.println("Testing getSize with empty Stack..");
        assertEquals(0, this.emptyS.getSize());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty with Stack..");
        assertTrue(this.emptyS.isEmpty());
        assertFalse(this.oneElemS.isEmpty());
        assertFalse(this.lstS.isEmpty());

    }

    @Test
    public void testToArray() {
        System.out.println("Testing toArray with non empty Stack..");
        assertArrayEquals(new Object[]{7, 6, 5, 4, 3, 2, 1}, this.lstS.toArray());

        System.out.println("Testing toArray with one element Stack..");
        assertArrayEquals(new Object[]{1}, this.oneElemS.toArray());

        System.out.println("Testing toArray with empty Stack..");
        assertArrayEquals(new Object[0], this.emptyS.toArray());

    }

    @Test
    public void testpeek() {
        System.out.println("Testing peek with non empty Stack..");
        Object top = this.lstS.peek();
        assertEquals(7, top);

        System.out.println("Testing peek with one element Stack..");
        Object top1 = this.oneElemS.peek();
        assertEquals(1, top1);

        System.out.println("Testing peek with empty Stack..");
        Object top2 = this.emptyS.peek();
        assertNull(top2);

    }

    @Test
    public void testPop() {
        System.out.println("Testing pop with non empty Stack..");
        Object top = this.lstS.pop();
        assertEquals(7, top);
        assertArrayEquals(new Object[]{6, 5, 4, 3, 2, 1}, this.lstS.toArray());

        System.out.println("Testing pop with one element Stack..");
        Object top1 = this.oneElemS.pop();
        assertEquals(1, top1);
        assertArrayEquals(new Object[0], this.oneElemS.toArray());

        System.out.println("Testing pop with empty Stack..");
        Object top3 = this.emptyS.pop();
        assertNull(top3);
        assertArrayEquals(new Object[0], this.emptyS.toArray());

    }

    @Test
    public void testPush() {
        System.out.println("Testing push with non empty Stack..");
        this.lstS.push(0);
        assertEquals(0, this.lstS.peek());

        assertArrayEquals(new Object[]{0, 7, 6, 5, 4, 3, 2, 1}, this.lstS.toArray());

        System.out.println("Testing push with one element Stack..");
        this.oneElemS.push(0);
        assertEquals(0, this.lstS.peek());
        assertArrayEquals(new Object[]{0, 1}, this.oneElemS.toArray());

        System.out.println("Testing push with empty Stack..");
        this.emptyS.push(0);
        assertArrayEquals(new Object[]{0}, this.emptyS.toArray());

    }

}
