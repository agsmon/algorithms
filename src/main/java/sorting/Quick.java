package sorting;

import edu.princeton.cs.algs4.StdRandom;
import utils.Utils;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // Eliminating dependence on the input
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi < lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort (a, lo, j-1);
        sort (a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // partition into a[lo, i-1], a[i], a[i+1, hi]
        Comparable v = a[lo];
        int i = lo; //left scan index
        int j = hi+1; //right scan index
        while (true) {
            // scan left
            while (a[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            // scan right
            while (a[--j].compareTo(v) > 0) {
                if (j == lo) {
                    break;
                }
            }
            // check for scan complete
            if (i >= j) {
                break;
            }
            // exchange
            Utils.exchange(a, i, j);
        }
        Utils.exchange(a, lo, j); // put v = a[j] into position
        return j; // with a[lo, j-1] <= a[j] <= a[j+1, hi].
    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 2, 1, 0, 4, 9, 6};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
