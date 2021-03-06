package ua.edu.ucu.collections.immutable;


import java.util.Arrays;


public final class ImmutableArrayList implements ImmutableList {
    private Object[] lst;
    private int size;

    public ImmutableArrayList() {
        //Class constructor with no arguments//
        this.lst = new Object[0];
        this.size = 0;
    }

    public ImmutableArrayList(Object[] list) {
        //Class constructor with an argument of some Object array
        checkEmptyArray(list);
        this.lst = Arrays.copyOf(list, list.length);
        this.size = list.length;
    }


    @Override
    public ImmutableArrayList add(Object elem) {
        // Adds element to the end of ImmutableArrayList

        return addAll(this.size, new Object[]{elem});
    }

    private void checkForIndex(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkEmptyArray(Object[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("The list is empty!");
        }
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});

    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(this.size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] temp = new Object[c.length + this.size];
        /* Copying all the elements from lst from 0 to index exclusive */
        System.arraycopy(this.lst, 0, temp, 0, index);
        /* Copying all the elements from c and putting on the index position*/
        System.arraycopy(c, 0, temp, index, c.length);
        /* Copying all the rest elements from this.lst to temp*/
        System.arraycopy(this.lst, index, temp,
                index + c.length, this.size - index);
        return new ImmutableArrayList(temp);
    }

    @Override
    public Object get(int index) {
        checkForIndex(index);
        return this.lst[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (isEmpty()) {
            return new ImmutableArrayList();
        }
        checkForIndex(index);
        Object[] temp = new Object[this.size - 1];
        System.arraycopy(this.lst, 0, temp, 0, index);
        System.arraycopy(this.lst, index + 1, temp,
                index, this.size - 1 - index);
        return new ImmutableArrayList(temp);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkForIndex(index);
        Object[] temp = this.toArray();
        temp[index] = e;
        return new ImmutableArrayList(temp);
    }

    @Override
    public int indexOf(Object e) {

        for (int i = 0; i < this.size; i++) {
            if (this.lst[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.lst, this.lst.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
