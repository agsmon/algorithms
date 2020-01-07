package sorting;

public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0 ; j--) {
                //Utils.exchange(a, j, j-1);
            }
        }
    }


}
