import java.util.Arrays;

/**
 * 165. Compare Version Numbers
 * @author Yihua Cai
 **/

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        System.out.println(Arrays.toString(s1));
        for (int i = 0; i < s1.length; i++) {
            if (i >= s2.length) {
                if (Integer.parseInt(s1[i]) != 0) return 1;
            } else {
                if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) return -1;
                else if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])) return 1;
            }
        }

        if (s2.length > s1.length) {
            for (int i = s1.length; i < s2.length; i++) {
                if (Integer.parseInt(s2[i]) != 0) return -1;
            }
        }

        return 0;
    }
}
