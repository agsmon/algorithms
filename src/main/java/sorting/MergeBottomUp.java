package sorting;

public class MergeBottomUp {
    private static Comparable aux[]; // auxiliary array for merges

    public static void sort(Comparable a[]) {
        int n = a.length;
        aux = new Comparable[n];
        for (int subSize = 1; subSize < n; subSize += subSize) { // subSize - subarray size
            for (int lo = 0; lo < n-subSize; lo += 2*subSize) { //lo -- subarray index
                merge(a, lo, lo+subSize-1, Math.min(lo+2*subSize-1, n-1));
            }
        }
    }

    //same as in Merge class
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
