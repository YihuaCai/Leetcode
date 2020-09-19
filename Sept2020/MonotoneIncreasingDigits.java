/**
 * @author Yihua Cai
 **/

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        if (s.length() <= 0) return N;
        StringBuilder sb = new StringBuilder();
        int n = -1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (n < 0) n = i - 1;
                else if (s.charAt(n) != s.charAt(i)) n = i - 1;
            } else if(s.charAt(i - 1) < s.charAt(i)) {
                n = i;
            } else
            if (s.charAt(i - 1) > s.charAt(i)) {
                if(n < 0) n = i - 1;
                sb.append(s.substring(0, n));
                sb.append((char)(s.charAt(n) - 1));
                sb.append("9".repeat(s.length() - n - 1));
                break;
            }
        }
        if (sb.length() == 0) sb.append(s);

        return Integer.parseInt(sb.toString());
    }
}
