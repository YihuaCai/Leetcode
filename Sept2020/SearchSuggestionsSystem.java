import java.lang.reflect.Array;
import java.util.*;

/**
 * 1268. Search Suggestions System
 * https://leetcode.com/problems/search-suggestions-system/
 * @author Yihua Cai
 **/

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(products);

        List<String> ls = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        List<String> left = new ArrayList<>();

        for (int i = searchWord.length() - 1; i >= 0; i--) {
            String s = searchWord.substring(0, i + 1);
            if (i == searchWord.length() - 1) {
                for (String p: products) {
                    if (p.startsWith(s)) {
                        ls.add(p);
                    } else {
                        left.add(p);
                    }
                }
                map.put(s, ls);
            } else {
                List<String> l = new ArrayList<>(ls);
                ls = l;
                List<String> ps = left;
                left = new ArrayList<>();
                for (String p: ps) {
                    if (p.startsWith(s)) {
                        ls.add(p);
                    } else {
                        left.add(p);
                    }
                }
                Collections.sort(ls);
                map.put(s, ls);
            }
            if (ls.size() > 3) ls = ls.subList(0, 3);
            res.add(ls);

            if (ls.size() == products.length) {
                if (ls.size() > 3) ls = ls.subList(0, 3);
                for (int m = 0; m < searchWord.length() - map.size(); m++) {
                    res.add(ls);
                }

                return res;
            }
        }

        Collections.reverse(res);
        return res;
    }
}
