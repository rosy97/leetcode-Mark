package Leetcode.arr;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode 739
//重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数
public class DailyTemperatures {
    public int[] nextTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //维护一个单调栈：存储索引，栈顶到栈底的顺序为低温到高温
        Stack<Integer> stack = new Stack<>();
        //使用链式结构存储，空间复杂度低
        Deque<Integer> stack1 = new LinkedList<Integer>();
        stack.add(0);
        for(int i=1;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int cur = stack.pop();
                res[cur]= i-cur;
            }
            stack.push(i);
        }
        //stack中剩余元素为0
//        while (!stack.isEmpty()){
//            res[stack.pop()]=0;
//        }
        return res;
    }

    public static void main(String[] args) {

    }
}
