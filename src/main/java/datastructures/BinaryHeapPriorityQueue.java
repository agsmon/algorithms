package datastructures;

public class BinaryHeapPriorityQueue<Key extends Comparable<Key>> {
    private Key[] a =  (Key[]) new Comparable[1];
    private int numberOfItems = 0;

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public void insert(Key key) {
        if(a.length == numberOfItems+1) {
            resize(2*a.length + 1);
        }
        a[++numberOfItems] = key;
        swim(numberOfItems);
    }

    public Key getMax() {
        Key max = a[1];
        a[1] = a[numberOfItems];
        a[numberOfItems] = null; // avoid loitering
        numberOfItems--;
        sink(1); //restore heap condition
        if (numberOfItems < a.length/4) {
            resize(a.length/2);
        }
        return max;
    }

    // move up the tree, comparing the node with its parent and exchanging if the parent is lesser
    private void swim(int index) {
        while (index > 1 && a[index/2].compareTo(a[index]) < 0) {
            Key temp = a[index];
            a[index] = a[index/2];
            a[index/2] = temp;
            index = index/2;
        }
    }

    // move down the tree, comparing with child nodes and exchanging if child is bigger
    private void sink(int index) {
        int j;
        while (2*index <= numberOfItems) {
            j = 2*index; // index of the nodes first child
            if (j < numberOfItems && a[j].compareTo(a[j+1]) < 0) {
                j++; // index of the nodes first child, if bigger then first
            }
            if (a[j].compareTo(a[index]) < 0) { // if parent is bigger, break
                break;
            }
            // exchange parent and child
            Key temp = a[index];
            a[index] = a[j];
            a[j] = temp;
            index = j; // move on
        }
    }

    private void resize(int newSize) {
        Key[] temp = (Key[]) new Comparable[newSize];
        for (int i = 0; i <= numberOfItems; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
