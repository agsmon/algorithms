package sorting;

/**
 * Created by olga on 17.12.2019.
 */
// top-down mergesort realization
public class Merge {
    private static Comparable[] aux; // auxiliary array for merges

    public static void sort (Comparable[] a) {
        aux = new Comparable[a.length]; // allocating space
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //merge a[lo, mid] with a[mid+1, hi]
        int i = lo;
        int j = mid+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; // storing initial array in auxiliary
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j];
                j++;
            } else if (j > hi) {
                a[k] = aux[i];
                i++;
            } else if (aux[j].compareTo(aux[i]) < 0) {
                a[k] = aux[j];
                j++;
            } else {
                a[k] = aux[i];
                i++;
            }
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
