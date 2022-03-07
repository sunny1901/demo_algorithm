package test1;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 如发现重复字符，就
                Character c = s.charAt(j);
                int num = map.get(c);
                i = Math.max( num , i );
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String agers[]){

        String str = "abcabcdbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";

        str = "abcbcabcdbb";
        int max = lengthOfLongestSubstring(str);
        System.out.println(max);

    }

}
