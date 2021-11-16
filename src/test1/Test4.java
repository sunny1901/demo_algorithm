package test1;

public class Test4 {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            Character c = s.charAt(j);
            i = Math.max(index[c], i);
            ans = Math.max(ans, j - i + 1);
            index[c] = j + 1;
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
