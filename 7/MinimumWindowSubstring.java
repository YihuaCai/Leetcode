/**
 * 76. Minimum Window Substring
 * @author Yihua Cai
 **/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] letter = new int[122];
        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'A']++;
        }

        int[] curr = new int[122];
        int start = 0;
        int i = 0;
        int n = 0;
        int minSize = Integer.MAX_VALUE;
        String minString = "";
        while(i < s.length()) {
            char c = s.charAt(i);
            if (letter[c - 'A'] == 0) {
                if (n == 0) {
                    start++;
                }
            } else {
                if (curr[c - 'A'] >= letter[c - 'A']) {

                    while(curr[s.charAt(start) - 'A'] > letter[s.charAt(start) - 'A'] || letter[s.charAt(start) - 'A'] == 0 || (s.charAt(start) == c && curr[s.charAt(start) - 'A'] >= letter[s.charAt(start) - 'A'])) {
                        curr[s.charAt(start) - 'A']--;
                        if (s.charAt(start) == c) {
                            n--;
                        }
                        start++;
                    }


                }

                if (curr[c - 'A'] < letter[c - 'A']) n++;
                curr[c - 'A']++;
                if (n == t.length()) {
                    if (minSize > i - start + 1) {
                        minSize = i - start + 1;
                        minString = s.substring(start, i + 1);
                        if (minSize == t.length()) return minString;
                    }
                }
            }
            i++;
        }

        return minString;
    }
}
