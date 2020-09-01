/**
 *
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * @author Yihua Cai
 **/

public class ReadNCharactersGivenRead4 {
    private int read4(char[] buf) {
        return 0;
    }
    public int read(char[] buf, int n) {
        if (n == 0) return 0;
        char[] buf4 = new char[4];
        int len = 0;
        int index = 0;
        while((len = read4(buf4)) > 0) {
            System.arraycopy(buf4, 0, buf, index, len);
            index += len;
        }
        if (index < n) return index;
        return n;
    }
}
