package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Least_kNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return (ArrayList)Arrays.asList(input);
        }
        //堆排序思想
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for(int element:input){
            if(ret.size()<k+1){
                ret = insertheap(element,ret);
            }else if(ret.get(1)>element){
                //element小于大根堆顶，删除堆顶，插入element
                ret.remove(ret.get(1));
                ret = insertheap(element,ret);
            }
        }
        ret.remove(0);
        return ret;
    }
    public ArrayList<Integer> buildheap(int[] arr){//建堆
        ArrayList<Integer> heap = new ArrayList<Integer>();
        heap.add(0);
        if (arr.length==0){
            return heap;}
        for (Integer element:arr){
            heap = insertheap(element,heap);
        }
        return heap;
    }
    public ArrayList<Integer> insertheap(Integer e, ArrayList<Integer> heap){//堆中插入
        heap.add(e);
        if(heap.size()==2){
            return heap;
        }
        int index = heap.size()-1;
        while(index>1){
            if(heap.get(index)>heap.get(index/2)){
                //大于父节点，向上交换
                int tem = heap.get(index);
                heap.set(index,heap.get(index/2));
                heap.set(index/2,tem);
                index /= 2;
            }else{
                break;
            }
        }
        return heap;
    }


    public static void main(String[] args) {
        Least_kNumber solution=new Least_kNumber();
        System.out.println(solution.GetLeastNumbers_Solution(new int[]{1, 2, 4, 5, 3, 9}, 4));
    }
}

