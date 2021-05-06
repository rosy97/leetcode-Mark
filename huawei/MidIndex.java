package Leetcode.huawei;

public class MidIndex {
    public static int mid(int[] arr){
        int start=0,end=arr.length-1;
        int left=arr[start],right=arr[end];
        while(start<end){
            if(left<right){
                start++;
                left+=arr[start];
            }else if(left>right){
                end--;
                right+=arr[end];
            }else {
                start++;
                end--;
                if(start==end){
                    return start;
                }else {
                    start++;
                    left+=arr[start];
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(mid(new int[]{1,3,7,3,5,6}));
    }
}
