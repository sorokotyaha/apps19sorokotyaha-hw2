package ua.edu.ucu.collections;


import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedlst;

    public Queue() {
        this.linkedlst = new ImmutableLinkedList();
    }

    public Queue(Object[] lst) {
        this.linkedlst = new ImmutableLinkedList(lst);
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.linkedlst.getFirst();
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object first = this.linkedlst.getFirst();
        this.linkedlst = (ImmutableLinkedList) this.linkedlst.remove(0);
        return first;
    }

    public void enqueue(Object e) {
        this.linkedlst = (ImmutableLinkedList) this.linkedlst.add(e);
    }

    public int getSize() {
        return this.linkedlst.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public Object[] toArray() {
        return this.linkedlst.toArray();
    }

}
