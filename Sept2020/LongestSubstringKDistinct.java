import java.util.HashMap;
import java.util.Map;

/**
 * @author Yihua Cai
 **/

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int num = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) && map.size() == k) {
                if (num > max) max = num;
                while (map.size() > k - 1) {
                    if (map.getOrDefault(s.charAt(start), 0) == 1) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                    }
                    start++;
                    num--;
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            num++;
        }

        if (num > max) max = num;
        return max;
    }
}
