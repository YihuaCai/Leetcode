import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Yihua Cai
 **/

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int left = capacity;
        Arrays.sort(trips, (a, b)->(a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2] - b[2]));
        for (int[] t: trips) {
            while(!pq.isEmpty()) {
                int[] last = pq.peek();
                if (last[2] <= t[1]) {
                    left+=last[0];
                    pq.poll();
                } else {
                    break;
                }
            }
            if (t[0] > left) return false;
            left -= t[0];
            pq.add(t);
        }

        return true;
    }
}
