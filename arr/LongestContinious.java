package Leetcode.arr;

import java.util.HashSet;

//leetcode 128
//给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

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
