package Leetcode.microSoft;

import java.util.HashSet;

//返回字符串S中：同时存在大小写；且顺序最大的大写字母（A小于Z）
public class BigAtoZ {
    public static String solution1(String S) {
        // write your code in Java SE 8
        HashSet<Character> set = new HashSet<>();
        char[] chs = S.toCharArray();//a=97,z=122,A=65,Z=90
        for (char c : chs) {
            set.add(c);
        }
        char cur = 48;
        for (char c : chs) {
            if ((int) c <= 90 && set.contains((char) (c + 32))) {
                if ((int) cur < (int) c) {
                    cur = c;
                }
            }
        }
        String ans = String.valueOf(cur);
        return ans.equals("0") ? "NO" : ans;
    }
}
