package datastructures;

public class UnorderedArrayPriorityQueue<Key extends Comparable<Key>> {
    private Key[] a =  (Key[]) new Comparable[1];
    private int numberOfItems = 0;

    private void resize(int newSize) {
        Key[] temp = (Key[]) new Comparable[newSize];
        for (int i = 0; i < numberOfItems; i++) {
            temp[i] = a[i];
        }
        a = temp;

    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public void insert(Key key) {
        if(a.length == numberOfItems) {
            resize(2*a.length);
        }
        a[numberOfItems++] = key;
    }

    public Key getMax() {
        Key max = a[0];
        int maxIndex = 0; // index of the maximum element
        for (int i = 1; i < numberOfItems; i++) {
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
                maxIndex = i;
            }
        }
        a[maxIndex] = a[--numberOfItems]; // switching the maximum and the last, removing the last
        a[numberOfItems] = null;
        if (numberOfItems < a.length/4) {
            resize(a.length/2);
        }
        return max;
    }
}
