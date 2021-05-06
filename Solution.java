package Leetcode;


public class Solution {

//    public int[] solution(int[] arr,int k){
////        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0;i<arr.length;i++){
//            if(i+k+1>arr.length-1)
//                break;
//            int temp=arr[i+k+1];
//            arr[i+k+1]=arr[i];
//            arr[i]=temp;
//        }
//
//        return arr;
//    }
//
//
//    //给定 nums = [0,0,1,1,1,2,2,3,3,4],
//    //函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }

    public int maxNum(int a, int b){
        int res=0;
        int tmp=a<b?a:b;
        for(int i=tmp;i>=0;i--){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return res;
    }

    public int maxNum2(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if(max%min==0){
            return min;
        }
        return maxNum2(min,max%min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNum(4, 12));
        System.out.println(solution.maxNum2(25, 30));

    }
}
