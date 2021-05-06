package Leetcode.alibaba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//- 3.19
//第一题：给定n(n为偶数)个人，规定每个人可以得到一个a[i]的序号，若抽到的序号是某个数字的平方，则获奖，
//现有一种修改券，可以使自己抽到的序号增减一，每个人可以使用多张，问最少需要多少张修改券可以使获奖人数为一半。
//
//输入： 4     4 7 12 13
//输出 ： 2
//说明： 该序号数组中，4是2的2次幂，7需要两张修改券，所以至少需要两张
public class Half {
    public static int numbOf(int[] arr){
        int cur=0;
        List<Integer> times = new ArrayList<>();
        for(int i:arr){
            if(cur>=arr.length/2)
                return 0;
            if(Math.sqrt(i)*Math.sqrt(i)==i){
                cur++;
            }else {
                double up = Math.ceil(Math.sqrt(i));
                double down = Math.floor(Math.sqrt(i));
                times.add((int) Math.min((up*up-i),(i-down*down)));
            }
        }

        times.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?1:0;
            }
        });
        int res=0;
        for(int k=0;k<arr.length/2-cur;k++){
            res+=times.get(k);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numbOf(new int[]{4, 7, 12, 15}));
    }
}
