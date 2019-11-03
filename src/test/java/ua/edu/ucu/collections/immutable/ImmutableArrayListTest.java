package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private Object[] lst;
    private Object[] lstempty;
    private Object[] lstOneElem;
    private int elemInt;
    private String elemString;
    private double elemDouble;

    @Before
    public void setUp() {
        // Creating an empty and not empty Object arrays
        this.lst = new Object[] {1, 2, 3, 4, 5, 6, 7};
        this.lstempty = new Object[0];
        this.elemInt = 0;
        this.lstOneElem = new Object[] {elemInt};
        this.elemDouble = 100.2;
        this.elemString = "testString";


    }


    @Test
    public void testToArray() {
        System.out.println("Testing toArray an empty constructor..");
        ImmutableArrayList empty = new ImmutableArrayList();
        assertArrayEquals(this.lstempty, empty.toArray());

        System.out.println("Testing toArray with one element Object array..");
        Object[] one = new Object[] {0};
        ImmutableArrayList oneArray = new ImmutableArrayList(one);
        assertArrayEquals(this.lstOneElem, oneArray.toArray());


        System.out.println("Testing toArray with few elements Object array..");
        Object[] few = {1, 2, 3, 4, 5, 6, 7};
        ImmutableArrayList few_elem = new ImmutableArrayList(few);
        assertArrayEquals(this.lst, few_elem.toArray());

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAdd(){
        System.out.println("Testing add with empty ImmutableArrayList..");
        ImmutableArrayList withAddedEmpty = new ImmutableArrayList();

        withAddedEmpty = (ImmutableArrayList) withAddedEmpty.add(this.elemInt);

        Object[] exp = new Object[] {0};
        assertArrayEquals(exp, withAddedEmpty.toArray());

        System.out.println("Testing add with a non empty ImmutableList");
        ImmutableArrayList temp = new ImmutableArrayList(this.lst);
        ImmutableArrayList withAdded = (ImmutableArrayList) temp.add(this.elemInt);
        assertArrayEquals(this.lst, temp.toArray());
        Object[] expAdded = new Object[] {1, 2, 3, 4, 5, 6, 7, 0};
        assertArrayEquals(expAdded, withAdded.toArray());

        System.out.println("Testing add with index..");
        withAdded = (ImmutableArrayList) withAdded.add(4, this.elemInt);
        assertArrayEquals(new Object[] {1, 2, 3, 4, 0, 5, 6, 7, 0}, withAdded.toArray());

        System.out.println("Testing add with an exceeding index");
        withAdded = (ImmutableArrayList) withAdded.add(20, this.elemInt);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAll(){
        System.out.println("Testing addAll with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        empty = (ImmutableArrayList) empty.addAll(0, this.lst);
        assertArrayEquals(this.lst, empty.toArray());

        System.out.println("Testing addAll with non empty ImmutableArrayList");
        ImmutableArrayList added = new ImmutableArrayList(this.lst);
        Object[] toAdd = new Object[] {0, 0, 0};

        added = (ImmutableArrayList) added.addAll(2,toAdd);
        Object[] exp = new Object[] {1, 2, 0, 0, 0, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());

        System.out.println("Testing addAll with exceeding index..");
        added = (ImmutableArrayList) added.addAll(20, toAdd);
    }


    @Test (expected = IndexOutOfBoundsException.class)
    public void testGet(){
        System.out.println("Testing get with non empty ImmutableArrayList..");
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        assertEquals(this.lst[0], few.get(0));

        System.out.println("Testing get with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        Object some = empty.get(3);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemove(){
        System.out.println("Testing remove with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        ImmutableArrayList some = (ImmutableArrayList) empty.remove(0);
        assertEquals(0, some.size());

        System.out.println("Testing remove with non empty ImmutableArrayList..");
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        few = (ImmutableArrayList) few.remove(0);
        Object[] exp = new Object[] {2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, few.toArray());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableArrayList) few.remove(25);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet(){

        System.out.println("Testing set with non empty ImmutableArrayList..");
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        few = (ImmutableArrayList) few.set(0, this.elemInt);
        Object[] exp = new Object[] {0, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, few.toArray());

        System.out.println("Testing remove with exceeding index..");
        few = (ImmutableArrayList) few.set(25, this.elemInt);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetWithEmpty(){
        System.out.println("Testing set with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        ImmutableArrayList some = (ImmutableArrayList) empty.set(0, this.elemInt);
    }

    @Test
    public void testIndexOf(){
        System.out.println("Testing indexOf with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        int someInd =  empty.indexOf(100);
        assertEquals(-1, someInd);

        System.out.println("Testing indexOf with non empty ImmutableArrayList..");
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        int index = few.indexOf(2);
        assertEquals(1, index);

        System.out.println("Testing indexOf with element not in ImmutableArrayList");
        int index1 = few.indexOf(100);
        assertEquals(-1, index1);

    }

    @Test
    public void testSize(){
        System.out.println("Testing size.. ");
        ImmutableArrayList empty = new ImmutableArrayList();
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        assertNotEquals(empty.size(), few.size());
    }

    @Test
    public void testClear(){
        System.out.println("Testing clear.. ");
        ImmutableArrayList empty = new ImmutableArrayList();
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        ImmutableArrayList cleared = (ImmutableArrayList) few.clear();
        assertNotEquals(cleared.size(), few.size());
        assertEquals(empty.size(), cleared.size());
        assertArrayEquals(this.lst, few.toArray());
    }

    @Test
    public void testIsEmpty(){
        System.out.println("Testing isEmpty.. ");
        ImmutableArrayList empty = new ImmutableArrayList();
        ImmutableArrayList few = new ImmutableArrayList(this.lst);
        assertTrue(empty.isEmpty());
        assertFalse(few.isEmpty());
    }
}
