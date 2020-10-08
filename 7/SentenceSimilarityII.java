import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yihua Cai
 **/

public class SentenceSimilarityII {
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



    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> similarPairs) {

        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        Map<String, Integer> map = new HashMap<>();
        UnionFindSet uf = new UnionFindSet(similarPairs.size() * 2);
        int index = 0;
        for (int i = 0; i < similarPairs.size(); i++) {
            List<String> ls = similarPairs.get(i);
            int m = map.getOrDefault(ls.get(0), -1);
            if (m == -1) {
                m = index;
                index++;
                map.put(ls.get(0), m);
            }
            int n = map.getOrDefault(ls.get(1), -1);
            if (n == -1) {
                n = index;
                index++;
                map.put(ls.get(1), n);
            }
            uf.union(m, n);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            int m = map.getOrDefault(words1[i], -1);
            int n = map.getOrDefault(words2[i], -1);
            if (m == -1 || n == -1 || uf.find(m) != uf.find(n)) return false;
        }

        return true;
    }
}
