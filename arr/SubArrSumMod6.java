package Leetcode.arr;

import java.util.HashSet;
import java.util.Scanner;

public class SubArrSumMod6 {


    HashSet<Integer> set=null;//set保存sum减去的项的索引
    public static int six(int sum,int[] nums,HashSet<Integer> set){
        if(sum%6==0){
            //sum可以除尽，直接返回
            return sum;
        }
        int res=0;
        for(int i=0;!set.contains(i)&&i<nums.length;i++){
            set.add(i);
            int tmp=six(sum-nums[i],nums,set);
            if(tmp>res){
                res = tmp;
                set.remove(i);
            }
        }
        return res>0?res:-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一行输入n
        int n = sc.nextInt();
        int sum=0;
        int[] nums = new int[n];
        //第二行为长度为n的数组赋值
        for(int i = 0; i < n; i++){
            nums[i]=sc.nextInt();
            sum+=nums[i];//求出数组和sum
        }
        System.out.println(six(sum, nums, new HashSet<>()));
    }
}
