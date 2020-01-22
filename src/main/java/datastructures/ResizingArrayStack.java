package datastructures;

public class ResizingArrayStack<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int n = 0; // number of items

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int newSize) { // move stack to a new array of size max
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) { // add item to a top of the stack
        if (a.length == n) {
            resize(2*a.length);
        }
        a[n++] = item;
    }

    public Item pop() { // remove item from top of the stack
        Item item = a[--n];
        //a[n] = null; // avoid loitering
        //n--;
        if (n > 0 && n == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    public boolean isEmty() {
        return n == 0;
    }
}
