import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * @author Yihua Cai
 **/

public class OrangesRotting {
    private int s = 0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (queue.size() == 0 && fresh > 0) return -1;
        if (queue.size() > 0 && fresh > 0 && bfs(queue, fresh, grid) > 0) return -1;
        return s;
    }
    private int[] x = new int[]{0, 0, 1, -1};
    private int[] y = new int[]{1, -1, 0, 0};
    private int bfs(Queue<int[]> q, int fresh, int[][] g) {
        s++;
        Queue<int[]> queue = new LinkedList<>();
        while(!q.isEmpty()) {
            int[] og = q.poll();
            for (int i = 0; i < x.length; i++) {
                int m = og[0] + x[i];
                int n = og[1] + y[i];
                if (m < 0 || n < 0 || m >= g.length || n >= g[0].length) continue;
                if (g[m][n] != 1) continue;
                g[m][n] = 2;
                fresh--;
                queue.add(new int[]{m, n});
            }
        }
        if (queue.size() > 0 && fresh > 0) return bfs(queue, fresh, g);
        return fresh;
    }


}
