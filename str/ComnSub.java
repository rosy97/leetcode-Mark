package Leetcode.str;

//leetcode 1143 最长公共子序列
// "ace" 是 "abcde" 的子序列
public class ComnSub {
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1=="" || text2=="")
            return 0;
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];//最大为dp[l1][l2]，dp[i][j]表示text1前i个，text2前j个的公共子序列长度
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                if(i==0 || j==0){//序列的前0个，为0
                    dp[i][j]=0;
                }else {
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        // text1[i]不等于text2[j]时
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

}
