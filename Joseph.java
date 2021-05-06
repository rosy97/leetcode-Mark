package Leetcode;

import java.util.Stack;

public class Joseph {

    public int solution(int n,int m){
        if(n==1)
            return 0;
        else
            return (solution(n-1,m)+m)%(n);
    }
    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        System.out.println(joseph.solution(8, 5));

        String s = "ack0";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
    }

}

