package Leetcode.sort;

public class MergeSort {

    //为arr【start,end】区间内的序列排序
    public static int[] sort(int[] arr,int start, int end){
        if(start==end)
            return new int[]{arr[start]};
        int mid=(start+end)/2;
        return merge(sort(arr,start,mid),sort(arr,mid+1,end));
    }

    //归并函数：合并两个有序序列
    public static int[] merge(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length+ arr2.length];
        int i=0,i1=0,i2=0;
        while (i1<arr1.length&&i2<arr2.length){
            res[i++]=arr1[i1]<arr2[i2]?arr1[i1++]:arr2[i2++];
        }
        while (i1<arr1.length){
            res[i++]=arr1[i1++];
        }
        while (i2<arr2.length){
            res[i++]=arr2[i2++];
        }
        return res;
    }
    public static void main(String[] args) {
        for(int i:sort(new int[]{5, 4, 3, 6, 1,9,2,7},0,7)){
            System.out.println(i);
        }

    }
}
