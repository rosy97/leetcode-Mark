package Leetcode.arr;

public class FindTargetIdx {
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

    public static void main(String[] args) {
        for(int i:searchRange(new int[]{1}, 1)){
            System.out.println(i);
        }

    }
}
