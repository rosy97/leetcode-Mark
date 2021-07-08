package Leetcode.sort;

public class Bubble {
    //冒泡
    public static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){//从小到大
                    int tmp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return arr;
    }

    //选择排序：从低位到高位，每次找到最小的放在对应位
    public static int[] selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int tmp=i;
            for(int j=i+1;j<arr.length;j++){//每次在[i+1,结束]中选出最小的，并和arr[i]交换
                if(arr[tmp]>arr[j]){
                    tmp=j;
                }
            }
            int s=arr[i];
            arr[i]=arr[tmp];
            arr[tmp]=s;
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){//将【0，i】看作有序区间，将arr[i+1]插入其中
                if(arr[j-1]>arr[j]){
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }else
                    break;
            }
        }
        return arr;
    }

    //二分插入排序
    public static int[] insertSortByMid(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //将【0，i】看作有序区间，将arr[i+1]插入其中,该过程可以选用二分查找优化
            int idx=midFind(arr,0,i,arr[i+1]);//找到插入位置
            int tmp=arr[i+1];
            for(int j=i+1;j>idx;j--){
                arr[j]=arr[j-1];
            }
            arr[idx]=tmp;
        }
        return arr;
    }
    public static int midFind(int[] arr,int start, int end,int target){
        //二分插入查找，返回要插入位置的索引
        if(start==end)
            return arr[start]<target?start+1:start;
        if(arr[end]>target&&arr[end-1]<=target)
            return end;
        int mid=(start+end)/2;
        if(arr[mid]<target){
            return midFind(arr,mid+1,end,target);
        }else {
            return midFind(arr,start,mid,target);
        }
    }

    public static void main(String[] args) {
        for(int i:insertSortByMid(new int[]{5, 4, 3, 6, 1,9,2,7})){
            System.out.println(i);
        }
    }
}
