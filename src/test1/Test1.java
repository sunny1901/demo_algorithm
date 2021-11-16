package test1;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找出不含重复字符的【最长子串】长度。
 * */
public class Test1 {


    public static void func1(String str){
        int n = str.length();
        int ans = 0;
        String max = "";
        for( int i=0 ; i < n ; i++){
            System.out.println(i + "------------------------");
            for( int j= i+1  ; j <=n ; j++ ){
                if(allUnique(str , i , j ))
                    ans = Math.max( ans , j -i );
            }
        }


        System.out.println(ans);

    }


    public static boolean allUnique(String s , int start , int end ){
        System.out.println(">"+start +":" + end);
        Set<Character> set = new HashSet();
        for( int i  = start ; i<end ; i++){
            Character ch = s.charAt(i);
            System.out.println( "\t"+ i + "-" + ch);
            if( set.contains( ch )){
                return false;
            }
            set.add( ch );
        }

        return true;

    }



    public static void main(String agers[]){

        String str = "abcabcdb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";

        func1(str);

    }



}
