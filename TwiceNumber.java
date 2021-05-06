package Leetcode;

import java.util.HashMap;
import java.util.Map;

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
// 请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
//返回描述：
//如果数组中有重复的数字，函数返回true，否则返回false。
//如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。
public class TwiceNumber {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<length;i++){
            Integer integer = map.get(numbers[i]);
            if(integer!=null){
                duplication[0]=numbers[i];
                System.out.println(duplication[0]);
                return true;
            }
//            System.out.println(integer);
            map.put(numbers[i],i);
        }
        return false;

    }
    public static void main(String[] args) {

        int[] numbers = new int[]{1,5,4,5,2,3};
        int [] duplication =new int[3];
        TwiceNumber n = new TwiceNumber();
        System.out.println(n.duplicate(numbers, numbers.length, duplication));

    }
}
