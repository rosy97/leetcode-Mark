package Leetcode.arr;

import java.util.HashSet;

public class LongestContinious {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }

        int curLen=0,res=0;
        for(int n:set){
            if(!set.contains(n-1)){//找到一个连续序列的起点（最小值）
                curLen=1;
                int cur=n+1;
                while (set.contains(cur)){
                    curLen++;
                    cur++;
                }
                res=Math.max(curLen,res);
            }
        }

        return res;
    }
    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
