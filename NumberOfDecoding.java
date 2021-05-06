package Leetcode;

import java.io.FileInputStream;

public class NumberOfDecoding {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<dp.length; i++){
            if(s.charAt(i-1)!='0'){
                if(s.charAt(i-2)=='0'){
                    dp[i]=dp[i-1];
                }else
                    dp[i] = Integer.parseInt(""+s.charAt(i-2)+s.charAt(i-1))>26 ? dp[i-1] : dp[i-1]+dp[i-2];
            }else{
                int tem = Integer.parseInt(""+s.charAt(i-2)+s.charAt(i-1));
                if(tem==20||tem==10){
                    dp[i]=dp[i-2];
                }else{
                    return 0;
                }
            }
            System.out.println(dp[i]);
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        NumberOfDecoding d = new NumberOfDecoding();
        System.out.println(d.numDecodings("2101"));
    }
}
