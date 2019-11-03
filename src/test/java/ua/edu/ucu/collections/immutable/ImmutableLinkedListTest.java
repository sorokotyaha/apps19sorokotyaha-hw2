package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList lstEmpty;
    private ImmutableLinkedList lstOneElement;
    private ImmutableLinkedList lst;

    @Before
    public void setUp() {
        this.lstEmpty = new ImmutableLinkedList();
        this.lstOneElement = new ImmutableLinkedList(new Object[]{1});
        this.lst = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testToArray() {
        System.out.println("Testing toArray with empty ImmutableLinkedList");
        Object[] empty = this.lstEmpty.toArray();
        assertArrayEquals(new Object[0], empty);

        System.out.println("Testing toArray with one element ImmutableLinkedList");
        Object[] oneElement = this.lstOneElement.toArray();
        assertArrayEquals(new Object[]{1}, oneElement);

        System.out.println("Testing toArray with  non empty ImmutableLinkedList");
        Object[] lst = this.lst.toArray();
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7}, lst);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll() {
        System.out.println("Testing addAll with non Empty ImmutableLinkedList..");
        ImmutableLinkedList added = (ImmutableLinkedList) this.lst.addAll(3, new Object[]{9, 9, 9});
        Object[] exp = new Object[]{1, 2, 3, 9, 9, 9, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());
        added = (ImmutableLinkedList) added.addAll(new Object[]{0, 0, 0});
        assertArrayEquals(new Object[]{1, 2, 3, 9, 9, 9, 4, 5, 6, 7, 0, 0, 0}, added.toArray());

        System.out.println("Testing addAll with one element ImmutableLinkedList..");
        ImmutableLinkedList addedOne = (ImmutableLinkedList) this.lstOneElement.addAll(0, new Object[]{9, 9, 9});
        Object[] expOne = new Object[]{9, 9, 9, 1};
        assertArrayEquals(expOne, addedOne.toArray());
        ImmutableLinkedList addedOne1 = (ImmutableLinkedList) this.lstOneElement.addAll(new Object[]{9, 9, 9});
        assertArrayEquals(new Object[]{1, 9, 9, 9}, addedOne1.toArray());

        System.out.println("Testing addAll with empty ImmutableLinkedList..");
        ImmutableLinkedList addedEmpty = (ImmutableLinkedList) this.lstEmpty.addAll(new Object[]{9, 9, 9});
        Object[] expEmpty = new Object[]{9, 9, 9};
        assertArrayEquals(expEmpty, addedEmpty.toArray());

        addedEmpty = (ImmutableLinkedList) this.lstEmpty.addAll(0, new Object[]{9, 9, 9});
        assertArrayEquals(expEmpty, addedEmpty.toArray());


        System.out.println("Testing addAll with exceeding index..");
        addedEmpty = (ImmutableLinkedList) this.lstEmpty.addAll(25, new Object[]{9, 9, 9});

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd() {
        System.out.println("Testing add with non Empty ImmutableLinkedList..");
        ImmutableLinkedList added = (ImmutableLinkedList) this.lst.add(3, 9);
        Object[] exp = new Object[]{1, 2, 3, 9, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());
        added = (ImmutableLinkedList) added.add(0);
        assertArrayEquals(new Object[]{1, 2, 3, 9, 4, 5, 6, 7, 0}, added.toArray());

        System.out.println("Testing add with one element ImmutableLinkedList..");
        ImmutableLinkedList addedOne = (ImmutableLinkedList) this.lstOneElement.add(0, 9);
        Object[] expOne = new Object[]{9, 1};
        assertArrayEquals(expOne, addedOne.toArray());
        ImmutableLinkedList addedOne1 = (ImmutableLinkedList) this.lstOneElement.add(9);
        assertArrayEquals(new Object[]{1, 9}, addedOne1.toArray());

        System.out.println("Testing add with empty ImmutableLinkedList..");
        ImmutableLinkedList addedEmpty = (ImmutableLinkedList) this.lstEmpty.add(9);
        Object[] expEmpty = new Object[]{9};
        assertArrayEquals(expEmpty, addedEmpty.toArray());

        addedEmpty = (ImmutableLinkedList) this.lstEmpty.add(0, 9);
        assertArrayEquals(expEmpty, addedEmpty.toArray());


        System.out.println("Testing addAll with exceeding index..");
        addedEmpty = (ImmutableLinkedList) this.lstEmpty.add(25, 9);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() {
        System.out.println("Testing get with non empty ImmutableLinkedList..");
        Object elem = this.lst.get(3);
        assertEquals(this.lst.toArray()[3], elem);

        System.out.println("Testing get with one element ImmutableLinkedList..");
        Object elem2 = this.lstOneElement.get(0);
        assertEquals(this.lstOneElement.toArray()[0], elem2);

        System.out.println("Testing get with empty ImmutableLinkedList..");
        Object elem3 = this.lstEmpty.get(0);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove() {
        System.out.println("Testing remove with empty ImmutableLinkedList..");
        ImmutableLinkedList some = (ImmutableLinkedList) this.lstEmpty.remove(0);

        assertEquals(0, some.size());

        System.out.println("Testing remove with non empty ImmutableLinkedList..");
        ImmutableLinkedList few = (ImmutableLinkedList) this.lst.remove(0);
        assertArrayEquals(new Object[]{2, 3, 4, 5, 6, 7}, few.toArray());

        System.out.println("Testing remove with one element ImmutableLinkedList..");
        ImmutableLinkedList one = (ImmutableLinkedList) this.lstOneElement.remove(0);
        assertEquals(0, one.size());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableLinkedList) few.remove(25);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {
        System.out.println("Testing set with non empty ImmutableLinkedList..");
        ImmutableLinkedList few = new ImmutableLinkedList(this.lst.toArray());
        few = (ImmutableLinkedList) few.set(0, 9);
        Object[] exp = new Object[]{9, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, few.toArray());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableLinkedList) few.set(25, 9);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithEmpty() {
        System.out.println("Testing set with empty ImmutableLinkedList..");
        ImmutableLinkedList empty = new ImmutableLinkedList();
        ImmutableLinkedList some = (ImmutableLinkedList) empty.set(0, 9);
    }

    @Test
    public void testIndexOf() {
        System.out.println("Testing indexOf with empty ImmutableLinkedList..");
        ImmutableLinkedList empty = new ImmutableLinkedList();
        int someInd = empty.indexOf(100);
        assertEquals(-1, someInd);

        System.out.println("Testing indexOf with non empty ImmutableLinkedList..");
        ImmutableLinkedList few = new ImmutableLinkedList(this.lst.toArray());
        int index = few.indexOf(2);
        assertEquals(1, index);

        System.out.println("Testing indexOf with element not in ImmutableLinkedList");
        int index1 = few.indexOf(100);
        assertEquals(-1, index1);

    }

    @Test
    public void testSize() {
        System.out.println("Testing size.. ");
        ImmutableLinkedList empty = new ImmutableLinkedList();
        ImmutableLinkedList few = new ImmutableLinkedList(this.lst.toArray());
        assertNotEquals(empty.size(), few.size());
    }

    @Test
    public void testClear() {
        System.out.println("Testing clear.. ");
        ImmutableLinkedList cleared = (ImmutableLinkedList) this.lst.clear();
        assertNotEquals(cleared.size(), this.lst.size());
        assertEquals(this.lstEmpty.size(), cleared.size());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty.. ");
        ImmutableLinkedList few = new ImmutableLinkedList(this.lst.toArray());
        assertTrue(this.lstEmpty.isEmpty());
        assertFalse(few.isEmpty());
    }

    @Test
    public void testAddFirst(){
        System.out.println("Testing addFisrt with non Empty ImmutableLinkedList..");
        ImmutableLinkedList added = this.lst.addFirst(9);
        Object[] exp = new Object[]{9, 1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());

        System.out.println("Testing addFirst with one element ImmutableLinkedList..");
        ImmutableLinkedList addedOne = this.lstOneElement.addFirst(9);
        Object[] expOne = new Object[]{9, 1};
        assertArrayEquals(expOne, addedOne.toArray());


        System.out.println("Testing addFirst with empty ImmutableLinkedList..");
        ImmutableLinkedList addedEmpty = this.lstEmpty.addFirst(9);
        Object[] expEmpty = new Object[]{9};
        assertArrayEquals(expEmpty, addedEmpty.toArray());


    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetFirst(){
        System.out.println("Testing getFirts with non empty ImmutableLinkedList..");
        Object elem = this.lst.getFirst();
        assertEquals(this.lst.toArray()[0], elem);

        System.out.println("Testing getFirst with one element ImmutableLinkedList..");
        Object elem2 = this.lstOneElement.getFirst();
        assertEquals(this.lstOneElement.toArray()[0], elem2);

        System.out.println("Testing getFirst with empty ImmutableLinkedList..");
        Object elem3 = this.lstEmpty.getFirst();

    }

    @Test
    public void testAddLast(){
        System.out.println("Testing addLast with non Empty ImmutableLinkedList..");
        ImmutableLinkedList added = this.lst.addLast(9);
        Object[] exp = new Object[]{1, 2, 3, 4, 5, 6, 7, 9};
        assertArrayEquals(exp, added.toArray());

        System.out.println("Testing addLast with one element ImmutableLinkedList..");
        ImmutableLinkedList addedOne = this.lstOneElement.addLast(9);
        Object[] expOne = new Object[]{1, 9};
        assertArrayEquals(expOne, addedOne.toArray());


        System.out.println("Testing addLast with empty ImmutableLinkedList..");
        ImmutableLinkedList addedEmpty = this.lstEmpty.addLast(9);
        Object[] expEmpty = new Object[]{9};
        assertArrayEquals(expEmpty, addedEmpty.toArray());

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetLast(){
        System.out.println("Testing getLast with non empty ImmutableLinkedList..");
        Object elem = this.lst.getLast();
        assertEquals(this.lst.toArray()[this.lst.size() - 1], elem);

        System.out.println("Testing getLast with one element ImmutableLinkedList..");
        Object elem2 = this.lstOneElement.getLast();
        assertEquals(this.lstOneElement.toArray()[0], elem2);

        System.out.println("Testing getLast with empty ImmutableLinkedList..");
        Object elem3 = this.lstEmpty.getLast();

    }




}
