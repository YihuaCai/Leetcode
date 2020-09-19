/**
 * 402. Remove K Digits
 * @author Yihua Cai
 **/

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        int n = 0;
        if (k == num.length()) return "0";
        while(n < k) {
            boolean removed = false;
            for (int i = 1; i < num.length(); i++) {
                if (num.charAt(i) < num.charAt(i - 1)) {
                    num = num.substring(0, i - 1) + num.substring(i, num.length());
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                num = num.substring(0, num.length() - 1);
            }
            n++;
        }
        int zero = -1;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') zero = i;
            else break;
        }
        if (zero >= 0) {
            if (zero == num.length() - 1) return "0";
            else return num.substring(zero + 1, num.length());
        }
        return num.equals("") ? "0" : num;
    }
}
