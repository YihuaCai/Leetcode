/**
 * 684. Redundant Connection
 * @author Yihua Cai
 **/

public class RedundantConnection {
    private class UnionFindSet{
        private int[] parents;
        private int[] ranks;
        UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        private int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        private boolean union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) return false;
            if (ranks[rootx] > ranks[rooty]) {
                parents[rooty] = rootx;
            } else if (ranks[rootx] < ranks[rooty]) {
                parents[rootx] = rooty;
            } else {
                parents[rooty] = rootx;
                ranks[rootx]++;
            }
            return true;
        }

    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet uf = new UnionFindSet(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }
}
