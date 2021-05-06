package Leetcode.str;

import java.util.HashSet;

//求最长连续不重复子串
public class DifferentSubString {

    //滑动窗口
    public static String def(String s){
        HashSet<Character> set = new HashSet<>();
        int cur=0;
        int start= 0;
        int res=0;
        int left=-1;
        int right=-1;
        for(int i=0;i<s.length();i++){
            for(int j=start;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    start=j;
                    break;
                }
                if(j==s.length()-1){
                    return s.substring(i,j+1);
                }
                set.add(s.charAt(j));
                cur++;
            }
            if(cur>res){
                res=cur;
                left=i;
                right=start;
            }
            set.remove(s.charAt(i));
            cur--;
        }
        return s.substring(left,right);
    }

    //动态规划
    public static String def1(String s){
        String[] dp = new String[s.length()];//dp[i-1]表示s长度为 i 时的最长不重复子串
        dp[0] = s.substring(0,1);
        for(int i=1;i<s.length();i++){
            String tmp1 = dp[i-1];
            StringBuffer sb = new StringBuffer();
            for(int j=i;j>=0;j--){
                if(-1!=sb.indexOf(String.valueOf(s.charAt(j)))){
                    break;
                }
                sb.append(s.charAt(j));
            }
            String tmp2 = new String(sb.reverse());
            dp[i] = tmp1.length()>tmp2.length()?tmp1:tmp2;
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(def("dsaffgdxcvb"));

        System.out.println(def1("dsaffgdxcvb"));
    }
}
