package Leetcode;

import java.util.*;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//leetcode 1
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int k=0;k<l;k++){
            map.put(nums[k],k); //用hash表保存原数组的：数值-索引 信息。
        }
        //int[] sortNums = Arrays.copyOf(nums,l);
        Arrays.sort(nums);//将数组从小到大排序
        int i = 0;
        int j = l-1;
        if(nums[j-1]+nums[j] < target || nums[0]+nums[1] > target){
            return null;
        }
        while(i<j){
            if(nums[i]+nums[j]==target){
                //找到目标组合，返回原有索引
                return new int[]{map.get(nums[i]),map.get(nums[j])};
            }
            else if(nums[i]+nums[j]>target)//大于目标值，需要减小大数
                j--;
            else //小于目标值，增大小数
                i++;
        }
        return null;
    }

    //官方题解
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //{3, 3}数组添加时：3-0先添加，3-1添加时 由于键相同会覆盖3-0。
        }
        System.out.println(map.size()); //此时size为 1.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                //当数组包含相同数时，只会返回 最大的索引。
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        TwoSum ts =new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum1(new int[]{3, 3}, 6)));

    }
}
