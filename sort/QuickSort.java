package Leetcode.sort;

import java.util.Scanner;

public class QuickSort {

    public int[] quick(int[] arr,int low, int high){
        if(low<high){
            int index = getIndex(arr,low,high);
            quick(arr,low,index-1);
            quick(arr,index+1,high);
        }
        return arr;
    }

    //给基准数据找出正确索引的过程，选第一个数arr[left]为基准数据
    public int getIndex(int[] arr,int left,int right){
        int temp = arr[left];
        while (left<right){
            while (left<right && temp<=arr[right]){
                right--;
            }
            arr[left]=arr[right];
            while(left<right && temp>=arr[left]){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=temp;//此时left==right，且为tmp的正确位置
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Scanner in = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        for(int i:quickSort.quick(arr,0,arr.length-1)){
            System.out.println(i);
        }
    }

}
