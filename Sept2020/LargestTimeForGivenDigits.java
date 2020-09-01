import java.util.*;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * @author Yihua Cai
 **/

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int lessThan3 = 0;
        int largerThan6 = 0;
        List<Integer> ls = new ArrayList<>();
        for (int i: A) {
            ls.add(i);
            if (i < 0) return "";
            if (i < 3) {
                lessThan3++;
            } else if (i >= 6) {
                largerThan6++;
            }
        }

        if (lessThan3 == 0) return "";
        if (largerThan6 > 2) return "";
        int[] res = new int[4];
        Collections.sort(ls, Collections.reverseOrder());
        if (getLargestTime(ls, 0, res)) {
            return res[0] + "" + res[1] + ":" + res[2] + "" + res[3];
        }
        return "";
    }


    private boolean getLargestTime(List<Integer> ls, int digit,  int[] res) {
        if (ls.size() == 0) return true;

        for (int i = 0; i < ls.size(); i++) {
            int n = ls.get(i);
            if (digit == 0 && n < 3 || digit == 1 && res[0] == 2 && n < 4
                    || digit == 1 && res[0] < 2 || digit == 2 && n < 6
                    || digit == 3)
            {

                ls.remove(i);
                res[digit] = n;
                boolean f = getLargestTime(new ArrayList<>(ls), digit+1, res);
                if (f) return true;
                ls.add(i, n);
            }
        }

        return false;
    }
}
