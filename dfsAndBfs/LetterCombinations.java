package Leetcode.dfsAndBfs;

import java.util.ArrayList;
import java.util.List;

//leetcode 17
public class LetterCombinations {
    public static char[][] map = new char[][]{
                    {'a','b','c'},{'d','e','f'},
                    {'g','h','i'},{'j','k','l'},{'m','n','o'},
                    {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'} };
    static List<String> res = new ArrayList<>();

    public static List<String> letterCombination(String digits) {
        StringBuilder sb = new StringBuilder();
        allLetters(digits,res,sb);
        return res;
    }
    public static void allLetters(String digits, List<String> res, StringBuilder sb) {
        if(sb.length()==digits.length()){
            res.add(new String(sb));
            return;
        }
        int i=sb.length();
        for(char c:map[Integer.valueOf(digits.charAt(i)) - 2-48]){
            sb.append(c);
            allLetters(digits,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("123".charAt(1)) );
    }
}
