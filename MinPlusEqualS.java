package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//list 输出两个数，小的先输出
public class MinPlusEqualS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        if(array.length==0 || array[0]>sum){
            return list;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        for(int e:array){
            if(map.get(sum - e)!=null){
                list.add(e);
                list.add(sum-e);
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        MinPlusEqualS minPlusEqualS = new MinPlusEqualS();

    }
}
