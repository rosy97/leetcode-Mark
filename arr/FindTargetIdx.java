package Leetcode.arr;

//leetcode 34
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回[-1, -1]。

public class FindTargetIdx {
    //方法1
    public static int[] searchRange(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        int[] res = new int[]{-1,-1};
        if(right==0 && nums[right]==target){
            return new int[]{right,right};
        }
        while(right>left){
            if(nums[(left+right)/2]>target){
                right=(left+right)/2;
            }else if(nums[(left+right)/2]<target){
                if(left==(left+right)/2){
                    if(nums[right]!=target) return res;
                    else return new int[]{right,right};
                }
                left=(left+right)/2;
            }else{
                res[0]=(left+right)/2;
                res[1]=(left+right)/2;
                for(int i=(left+right)/2;i<nums.length;i++){
                    if(nums[i]!=target) break;
                    res[1]=i;
                }
                for(int i=(left+right)/2;i>=0;i--){
                    if(nums[i]!=target) break;
                    res[0]=i;
                }
                break;
            }
        }
        return res;
    }

    //方法2 二分查找,返回对应索引/-1
    public static int binarySearch(int[] arr, int target, int start, int end){
        if(start>end)
            return -1;
        if(start==end)
            return arr[start]==target?start:-1;
        int mid = (start+end)/2;
        if(arr[mid]==target)
            return mid;
        else if(arr[mid]<target)
            return binarySearch(arr,target,mid+1,end);
        else
            return binarySearch(arr,target,start,mid-1);
    }
    public static int[] findIdx(int[] nums, int target){
        int cur=binarySearch(nums,target,0, nums.length-1);
        int start=cur,end=cur;
        while(cur!=-1){
            start = cur;
            cur = binarySearch(nums,target,0, cur-1);
        }
        cur=end;
        while(cur!=-1){
            end = cur;
            cur = binarySearch(nums,target,cur+1, nums.length-1);
        }
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        for(int i:searchRange(new int[]{1}, 1)){
            System.out.println(i);
        }
        for(int i:findIdx(new int[]{1, 2, 3, 3, 3, 4, 5}, 3)){
            System.out.println(i);
        }
    }
}
