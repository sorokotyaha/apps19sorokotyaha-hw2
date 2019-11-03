package ua.edu.ucu.collections;


import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Stack {
    private ImmutableLinkedList linkedlst;

    public Stack() {
        this.linkedlst = new ImmutableLinkedList();
    }

    public Stack(Object[] list) {
        this.linkedlst = new ImmutableLinkedList(list);
    }

    public int getSize() {
        return this.linkedlst.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public Object[] toArray() {
        Object[] array = this.linkedlst.toArray();
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;

    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.linkedlst.getLast();
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object last = this.linkedlst.getLast();
        this.linkedlst = (ImmutableLinkedList) this.linkedlst.remove(this.getSize() - 1);
        return last;
    }

    public void push(Object e) {
        this.linkedlst = this.linkedlst.addLast(e);
    }


}
