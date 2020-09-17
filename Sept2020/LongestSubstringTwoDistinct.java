import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yihua Cai
 **/

public class LongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int num = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) && map.size() == 2) {
                if (num > max) max = num;
                while (map.size() > 1) {
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
