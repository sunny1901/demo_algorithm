package test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test2 {


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
//                set = new HashSet<>();
            }
        }
        return ans;
    }


    public static void main(String agers[]){


        String str = "abcabcdbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";

         str = "abcbcbcdbb";
        int max = lengthOfLongestSubstring(str);
        System.out.println(max);

    }


}
