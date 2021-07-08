package Leetcode.sort;

//堆排序：左子*2、右子*2+1、父节点/2
//  1
// 2  3
//4 5 6 7
public class HeapSort {


    //从小到大：使用小根堆，父节点小于左右子
    public static int[] buildHeap(int[] arr){
        int[] heap = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            //构建heap，索引从1开始
            heap[i+1]=arr[i];
        }
        //建堆
        for(int idx=1;idx<heap.length;idx++){
            while (idx>1 && heap[idx/2]>heap[idx]){
                //如果父亲节点大于子节点,交换二者
                int tmp=heap[idx];
                heap[idx]=heap[idx/2];
                heap[idx/2]=tmp;
                idx /= 2;
            }
        }
        return heap;
    }

    //弹出堆顶
    public static int deleteHead(int[] heap,int i){
        int min = heap[1];
        heap[1]=heap[heap.length-1-i];//把最末元素放在堆顶

        //将堆顶向下传递
        int idx=1;
        while (idx*2<heap.length-i && idx*2+1<heap.length-i){
            //如果父亲节点大于子节点,交换二者
            int tmp=heap[idx];
            if(heap[idx*2]<heap[idx*2+1]){
                heap[idx]=heap[idx*2];
                heap[idx*2]=tmp;
                idx*=2;
            }else {
                heap[idx]=heap[idx*2+1];
                heap[idx*2+1]=tmp;
                idx=idx*2+1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,6,2,4,8,3};
        int[] heap = buildHeap(arr);
        for (int i=0;i<arr.length;i++){
//            System.out.println(heap[i + 1]);
            System.out.println(deleteHead(heap,i));
        }
    }
}
