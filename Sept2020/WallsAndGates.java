import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * @author Yihua Cai
 **/

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        stepToGate(queue, 0, rooms);
    }

    private static int[] x = new int[]{0, 0, -1, 1};
    private static int[] y = new int[]{-1, 1, 0, 0};
    private final static int INF = 2147483647;
    private void stepToGate(Queue<int[]> q, int step, int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        step++;
        while(!q.isEmpty()) {
            int[] r = q.poll();
            for (int i = 0; i < x.length; i++) {
                int m = r[0] + x[i];
                int n = r[1] + y[i];
                if (m < 0 || n < 0 || m >= rooms.length || n >= rooms[0].length) continue;
                if (rooms[m][n] == -1) continue;
                if (rooms[m][n] == INF) {
                    rooms[m][n] = step;
                    queue.add(new int[]{m, n});
                }
            }
        }
        if (queue.size() > 0)
            stepToGate(queue, step, rooms);
    }
}
