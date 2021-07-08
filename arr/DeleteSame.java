package Leetcode.arr;

//leetcode 26
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
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

    //双指针：需要一个指针指向：待插入的位置/保留区的最后一位
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        int j = 0;//一个指针 i 进行数组遍历，另外一个指针 j 指向有效数组的最后一个位置。
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shua-chuan-lc-jian-ji-shuang-zhi-zhen-ji-2eg8/
//    来源：力扣（LeetCode）

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}














