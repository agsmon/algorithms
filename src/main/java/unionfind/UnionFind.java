package unionfind;

import java.util.ArrayList;

/**
 * Created by olga on 21.12.2019.
 */
public class UnionFind {
    private int[] id;
    private int count; //number of components

    public UnionFind(int count) {
        this.count = count;
        id = new int[count + 1];
        for (int i = 0; i < count + 1; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    public boolean connected (int p, int q) {
        return find(p) == find(q);
    }

}
