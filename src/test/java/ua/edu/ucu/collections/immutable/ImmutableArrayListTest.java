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
        System.out.println("Testing with empty ImmutableArrayList..");
        ImmutableArrayList empty = new ImmutableArrayList();
        empty = (ImmutableArrayList) empty.addAll(0, this.lst);
        assertArrayEquals(this.lst, empty.toArray());


        System.out.println("Testing with non empty ImmutableArrayList");
        ImmutableArrayList added = new ImmutableArrayList(this.lst);
        Object[] toAdd = new Object[] {0, 0, 0};

        added = (ImmutableArrayList) added.addAll(2,toAdd);
        Object[] exp = new Object[] {1, 2, 0, 0, 0, 3, 4, 5, 6, 7};
        assertArrayEquals(exp, added.toArray());

        System.out.println("Testing with exceeding index..");
        added = (ImmutableArrayList) added.addAll(20, toAdd);
    }


}
