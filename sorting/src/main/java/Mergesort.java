/**
 * Created by olga on 17.12.2019.
 */
public class Mergesort {
    private static int[] b;
    private static int[] c;

    public Mergesort(int arrayLength) {
        b = new int[arrayLength];
        c = new int[arrayLength];
    }

    void mergesort(int[] a, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergesort(a, lo, mid);
        mergesort(a, mid + 1, hi);

        for (int k = lo; k <= mid; k++)
            b[k-lo] = a[k];

        for (int k = mid+1; k <= hi; k++)
            c[k-mid-1] = a[k];

        b[mid-lo+1] = 2147483647;
        c[hi - mid + 1] = 2147483647;

        int i = 0, j = 0;
        for (int k = lo; k <= hi; k++)
            if (c[j] < b[i]) {
                a[k] = c[j];
                j++;
            }
            else  {
                a[k] = b[i];
                i++;
            }
    }
}
