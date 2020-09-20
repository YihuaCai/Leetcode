import java.util.ArrayList;
import java.util.List;

/**
 * @author Yihua Cai
 **/

public class NumberOfWays {
    private static final int MOD = 1000000007;
    private static long[][] pt;
    public int numOfWays(int[] nums) {
        pt = getPascalValue(nums.length);
        List<Integer> ls = new ArrayList<>();
        for (int i: nums) {
            ls.add(i);
        }
        return (int) ((getWays(ls) - 1) % MOD);
    }

    private long getWays(List<Integer> nums) {
        if (nums.size() <= 2) return 1;
        List<Integer> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int root = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > root) r.add(num);
            else l.add(num);
        }
        return pt[r.size() + l.size()][l.size()] % MOD * getWays(r) % MOD * getWays(l) % MOD;
    }

    private long[][] getPascalValue(int n) {
        long[][] res = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) res[i][0] = res[i][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                res[i][j] = (res[i - 1][j] + res[i - 1][j - 1]) % MOD;
        return res;
    }
}
