package sorting;

import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "sorting.Insertion":
                Insertion.sort(a);
            case "Selection":
                Selection.sort(a);
            case "sorting.Shell":
                Shell.sort(a);
            case "Merge":
                Merge.sort(a);
            case "Quick":
                Quick.sort(a);
            case "Heap":
                Heap.sort(a);
        }
        return timer.elapsedTime();

    }

    public static double timeRandomInput(String alg, int arraySize, int quantityOfArrays) {
        // use alg to sort quantity of random arrays of given size
        double total = 0.0;
        Double[] a = new Double[arraySize];
        for (int i = 0; i < quantityOfArrays; i++) {
            for (int j = 0; j < arraySize; j++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }


}
