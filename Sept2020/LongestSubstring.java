import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author Yihua Cai
 **/

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int num = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (num > max) max = num;
                while (set.contains(c)) {
                    set.remove(s.charAt(start));
                    start++;
                    num--;
                }

            }
            set.add(c);
            num++;
        }

        if (num > max) max = num;
        return max;
    }
}
