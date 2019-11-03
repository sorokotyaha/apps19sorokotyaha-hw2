package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private Object[] lst;
    private Object[] lstEmpty;
    private Object[] lstOneElem;
    private ImmutableArrayList lstLL;
    private ImmutableArrayList oneElemLL;
    private ImmutableArrayList emptyLL;
    private int elemInt;


    @Before
    public void setUp() {
        // Creating an empty and not empty Object arrays
        this.lst = new Object[]{1, 2, 3, 4, 5, 6, 7};
        this.lstEmpty = new Object[0];
        this.elemInt = 0;
        this.lstOneElem = new Object[]{elemInt};
        this.lstLL = new ImmutableArrayList(this.lst);
        this.oneElemLL = new ImmutableArrayList(this.lstOneElem);
        this.emptyLL = new ImmutableArrayList();

    }


    @Test
    public void testToArray() {
        System.out.println("Testing toArray with an empty ImmutableLinkedList..");
        assertArrayEquals(this.lstEmpty, this.emptyLL.toArray());

        System.out.println("Testing toArray with one element ImmutableLinkedList..");
        assertArrayEquals(this.lstOneElem, this.oneElemLL.toArray());

        System.out.println("Testing toArray with few elements ImmutableLinkedList..");
        assertArrayEquals(this.lst, this.lstLL.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd() {
        System.out.println("Testing add with empty ImmutableArrayList..");
        ImmutableArrayList withAddedEmpty = (ImmutableArrayList) this.emptyLL.add(this.elemInt);
        assertArrayEquals(this.lstOneElem, withAddedEmpty.toArray());

        System.out.println("Testing add with a non empty ImmutableList");
        ImmutableArrayList withAdded = (ImmutableArrayList) this.lstLL.add(this.elemInt);
        assertArrayEquals(this.lst, this.lstLL.toArray());
        Object[] expAdded = new Object[]{1, 2, 3, 4, 5, 6, 7, 0};
        assertArrayEquals(expAdded, withAdded.toArray());

        System.out.println("Testing add with index..");
        withAdded = (ImmutableArrayList) withAdded.add(4, this.elemInt);
        assertArrayEquals(new Object[]{1, 2, 3, 4, 0, 5, 6, 7, 0}, withAdded.toArray());

        System.out.println("Testing add with an exceeding index");
        withAdded = (ImmutableArrayList) withAdded.add(20, this.elemInt);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll() {
        System.out.println("Testing addAll with empty ImmutableArrayList..");
        ImmutableArrayList empty = (ImmutableArrayList) this.emptyLL.addAll(this.lst);
        assertArrayEquals(this.lst, empty.toArray());

        System.out.println("Testing addAll with non empty ImmutableArrayList");
        Object[] toAdd = new Object[]{0, 0, 0};
        ImmutableArrayList added = (ImmutableArrayList) this.lstLL.addAll(2, toAdd);
        Object[] exp = new Object[]{1, 2, 0, 0, 0, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());

        System.out.println("Testing addAll with exceeding index..");
        added = (ImmutableArrayList) added.addAll(20, toAdd);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        System.out.println("Testing get with non empty ImmutableArrayList..");
        assertEquals(this.lst[0], this.lstLL.get(0));

        System.out.println("Testing get with empty ImmutableArrayList..");
        Object some = this.emptyLL.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove() {
        System.out.println("Testing remove with empty ImmutableArrayList..");
        ImmutableArrayList some = (ImmutableArrayList) this.emptyLL.remove(0);
        assertEquals(0, some.size());

        System.out.println("Testing remove with non empty ImmutableArrayList..");
        ImmutableArrayList few = (ImmutableArrayList) this.lstLL.remove(0);
        Object[] exp = new Object[]{2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, few.toArray());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableArrayList) few.remove(25);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {

        System.out.println("Testing set with non empty ImmutableArrayList..");
        ImmutableArrayList few = (ImmutableArrayList) this.lstLL.set(0, this.elemInt);
        Object[] exp = new Object[]{0, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, few.toArray());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableArrayList) few.set(25, this.elemInt);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithEmpty() {
        System.out.println("Testing set with empty ImmutableArrayList..");
        ImmutableArrayList some = (ImmutableArrayList) this.emptyLL.set(0, this.elemInt);
    }

    @Test
    public void testIndexOf() {
        System.out.println("Testing indexOf with empty ImmutableArrayList..");
        int someInd = this.emptyLL.indexOf(100);
        assertEquals(-1, someInd);

        System.out.println("Testing indexOf with non empty ImmutableArrayList..");
        int index = this.lstLL.indexOf(2);
        assertEquals(1, index);

        System.out.println("Testing indexOf with element not in ImmutableArrayList");
        int index1 = this.lstLL.indexOf(100);
        assertEquals(-1, index1);

    }

    @Test
    public void testSize() {
        System.out.println("Testing size.. ");
        assertNotEquals(this.emptyLL.size(), this.lstLL.size());
    }

    @Test
    public void testClear() {
        System.out.println("Testing clear.. ");
        ImmutableArrayList cleared = (ImmutableArrayList) this.lstLL.clear();
        assertNotEquals(cleared.size(), this.lstLL.size());
        assertEquals(this.emptyLL.size(), cleared.size());
        assertArrayEquals(this.lst, this.lstLL.toArray());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty.. ");
        assertTrue(this.emptyLL.isEmpty());
        assertFalse(this.lstLL.isEmpty());
    }
}
