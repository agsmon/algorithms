package searching;

//not finished
//binary search in a symbol table - ordered array of keys
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int numberOfElements;

    public BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        values= (Value[]) new Comparable[1];
        numberOfElements = 0;
    }

    public int size() {
        return numberOfElements;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key, 0, numberOfElements - 1);
        if ((i < numberOfElements) && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value value) {
        int i  = rank(key, 0, numberOfElements - 1);

        //if (i)
    }

    public int rank(Key key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo)/2;
        int compare = key.compareTo(keys[mid]);
        if (compare < 0) {
            return rank(key, lo, mid - 1);
        } else if (compare > 0) {
            return rank(key, mid + 1, hi);
        }  else {
            return mid;
        }
    }

    //return number of items smaller than the key
    public int rank(Key key) {
        int lo = 0;
        int hi = numberOfElements - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            int compare = key.compareTo(keys[mid]);
            if(compare ==  0) {
                return mid;
            } else if (compare < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


}
