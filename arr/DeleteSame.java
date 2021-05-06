package Leetcode.arr;

public class DeleteSame {
    public static int removeDuplicates(int[] nums) {
        int cur=0,realLen=1;
        for(int i=0;i<nums.length;){
            while(cur<nums.length && nums[cur]==nums[i]){
                cur++;
            }
            if(cur<nums.length){
                nums[realLen]=nums[cur];
                realLen++;
            }
            i=cur;
        }
        return realLen;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
}














