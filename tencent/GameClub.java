package Leetcode.tencent;

import java.util.*;

public class GameClub {

    //n个游戏 0进入
    //ti时刻前完成 单位时间
    //扣wi荣誉值
    public static int coins(int[] t,int[] w){
        HashSet<Integer> set = new HashSet<>();
        for(int cur=0;cur<t.length;cur++){
            int minw=Integer.MIN_VALUE,mini=0;
            for(int i=0;i<t.length&&!set.contains(i);i++){
                if(cur<t[i]){
                    if(minw<w[i]){
                        minw=w[i];
                        mini=i;
                    }
                }
            }
            set.add(mini);
        }

        int res=0;
        for(int i=0;i<w.length;i++){
            if(!set.contains(i)){
                res+=w[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            int[] t = new int[n];
            int[] w = new int[n];
            for(int j=0;j<n;j++){
                t[j]=sc.nextInt();
            }
            for(int j=0;j<n;j++){
                w[j]=sc.nextInt();
            }
            System.out.println(coins(t, w));
        }
    }
}
