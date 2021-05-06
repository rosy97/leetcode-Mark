package Leetcode.alibaba;

//有序数组 A，数组中的每个数字都是 独一无二的，找出从数组最左边开始的第 K 个缺失数字。
//输入：A = [4,7,9,10], K = 3
//输出：8
//解释：
//缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。

public class Leet1060 {
    public static int solution(int[] arr, int k){
        int i=0,res=0;
        for(;k>0;k--){
            if(arr[i+1]-arr[i]>1){
                res = arr[i]+1;
                arr[i]+=1;
            }else {
                i++;
                k++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 9, 10}, 3));
    }
}
