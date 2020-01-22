package datastructures;

public class LinkedListStack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node top; // top of the stack
    private int n; // number of items

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) { // add item to top of the stack
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        n++;
    }

    public Item pop() { // remove item from top of the stack
        Item item = top.item;
        top = top.next;
        n--;
        return item;
    }
}
