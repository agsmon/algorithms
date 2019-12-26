import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by olga on 21.12.2019.
 */
public class Main {
    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        int n = input.length;
        System.out.println(n);
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < input.length - 1; i++) {
            int p = input[i];
            int q = input[i+1];
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
