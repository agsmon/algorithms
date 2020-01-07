package sorting;


import utils.Utils;

public class Shell {
    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1; // rearrange a as to taking every h-th entry (starting anywhere) yields a sorted subsequence
        while (h < length/3) {
            // h = 1, 4, 13, 40, ...
            h = 3*h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < length; i++) {
                // insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
                for (int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0 ; j--) {
                   Utils.exchange(a, j, j-1);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 2, 1, 0, 4, 9, 6};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
