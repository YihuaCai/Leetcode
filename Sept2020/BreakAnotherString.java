import java.util.Arrays;

/**
 * 1433. Check If a String Can Break Another String
 * @author Yihua Cai
 **/

public class BreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean less = false;
        boolean more = false;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] < c2[i]) {
                if (more) return false;
                less = true;
            } else if (c1[i] > c2[i]) {
                if (less) return false;
                more = true;
            }

        }
        return true;

    }
}
