import java.util.ArrayList;
import java.util.List;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * @author Yihua Cai
 **/

public class CountComponents {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }
        int i = 0;
        int c = 0;
        while (i < n) {
            if (visited[i] == 0) {
                connected(ls, visited, i);
                c++;
            }
            i++;
        }
        return c;
    }

    private void connected(List<List<Integer>> ls, int[] visited, int curr) {
        if (ls.get(curr).size() == 0) return;
        visited[curr] = 1;
        for (int i: ls.get(curr)) {
            if (visited[i] == 1) continue;
            connected(ls, visited, i);
        }
    }
}
