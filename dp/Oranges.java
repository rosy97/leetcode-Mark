package Leetcode.dp;

import java.util.*;

public class Oranges {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        return memo.get(n);
    }

    //最短路
    public int minDays1(int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] daysRest1, int[] daysRest2) {
                if (daysRest1[0] != daysRest2[0]) {
                    return daysRest1[0] - daysRest2[0];
                } else {
                    return daysRest1[1] - daysRest2[1];
                }
            }
        });
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, n});
        int ans = 0;
        while (true) {
            int[] daysRest = queue.poll();
            int days = daysRest[0], rest = daysRest[1];
            if (visited.contains(rest)) {
                continue;
            }
            visited.add(rest);
            if (rest == 1) {
                ans = days + 1;
                break;
            }
            queue.offer(new int[]{days + rest % 2 + 1, rest / 2});
            queue.offer(new int[]{days + rest % 3 + 1, rest / 3});
        }
        return ans;
    }

    //从小到大循环，超出内存限制
    public static int min1(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int tmp1 = dp[i-1]+1;
            int tmp2 = dp[i-1]+1;
            int tmp3 = dp[i-1]+1;
            if(i%2==0){
                tmp2 = dp[i/2]+1;
            }
            if(i%3==0){
                tmp3 = dp[i/3]+1;
            }
            dp[i]=Math.min(tmp1,Math.min(tmp2,tmp3));
        }
        return dp[n];
    }

    //从大到小递归
    public static int min2(int n){
        if(n<=1){
            return n;
        }
        int tmp1 = min2(n-1)+1;
        int tmp2 = tmp1;
        int tmp3 = tmp1;
        if(n%2==0){
            tmp2=min2(n/2)+1;
        }
        if(n%3==0){
            tmp3=min2(n/3);
        }
        return Math.min(tmp1,Math.min(tmp2,tmp3));
    }

    public static void main(String[] args) {
        System.out.println(min2(10));
    }

}
