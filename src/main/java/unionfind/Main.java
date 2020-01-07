package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.OptionalInt;


/**
 * Created by olga on 21.12.2019.
 */
public class Main {
    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        OptionalInt n = Arrays.stream(input).reduce(Integer::max);
        System.out.println(n.getAsInt());
        UnionFind uf = new UnionFind(n.getAsInt());
        for (int i = 0; i < input.length - 1; i+=2) {
            int p = input[i];
            int q = input[i+1];
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
