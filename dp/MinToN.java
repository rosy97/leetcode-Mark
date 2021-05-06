package Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

//返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
public class MinToN {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        int res = 0;
        List<Integer> listN = new ArrayList<>();
        while (n>0){
            listN.add(n-n/10*10);
            n/=10;
        }
        boolean isEqual = true;
        for(int i=listN.size()-1;i>=0;i--){//从高位向低位遍历

            for(int k=0;k<digits.length;k++){

                if(Integer.parseInt(digits[k])<listN.get(i)){
                    res+=Math.pow(digits.length,i);
                }else {
                    if(Integer.parseInt(digits[k])==listN.get(i)){

                        isEqual=true;
                    }else {
                        while (i>0){
                            res+=Math.pow(digits.length,i--);
                        }

                        isEqual=false;
                    }
                    break;
                }
            }
        }

        return isEqual?res:res-1;
    }

    public static int atMostNGivenDigitSet1(String[] D, int N) {
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            // dp[i]:表示所有符合要求的 k-i位数
            int Si = S.charAt(i) - '0';
            for (String d: D) {
                if (Integer.valueOf(d) < Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if (Integer.valueOf(d) == Si)
                    dp[i] += dp[i+1];
            }
        }

        for (int i = 1; i < K; ++i)
            dp[0] += Math.pow(D.length, i);
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet1(new String[]{"1","3","5","7"}, 345));
    }

}
