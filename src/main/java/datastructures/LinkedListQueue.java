package datastructures;

public class LinkedListQueue<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int itemsAmount;

    public boolean isEmpty() {
        return itemsAmount == 0;
    }

    public void add(Item item) {
        // add new last item to the queue
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        itemsAmount++;
    }

    public Item get() {
        // remove first item
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        itemsAmount--;
        return item;
    }

}
