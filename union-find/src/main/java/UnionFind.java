import java.util.ArrayList;

/**
 * Created by olga on 21.12.2019.
 */
public class UnionFind {
    private ArrayList<Integer> id;
    private int count; //number of components

    public UnionFind(int count) {
        this.count = count;
        id = new ArrayList<Integer>(count);
        for (int i = 0; i < count; i++) {
            id.add(i);
        }
    }

    public int count(){
        return count;
    }

    public int find(int p) {
        return id.get(p);
    }

    public void union(int p, int q) {
        int largest = Math.max(p, q);
        if (id.size() <= largest) {
            for (int i = id.size(); i <= largest; i++) {
                id.add(i, i);
            }
        }
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i) == pId) {
                id.add(i,qId);
            }
        }
        count--;
    }

    public boolean connected (int p, int q) {
        if (p < id.size() && q < id.size()) {
            return find(p) == find(q);
        }
        else
            return false;
    }

}
