package Leetcode.didi;


import java.util.Scanner;
import java.util.Stack;

public class Detete0123 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int res=0;
        for(int i=0;i<n;i++){
            if(chs[i]=='0'||chs[i]=='2'){
                stack.push(chs[i]);
            }
            else if(chs[i]=='1'&&stack.peek()=='0'){
                stack.pop();
                res++;
            }
            else if(chs[i]=='3'&&stack.peek()=='2'){
                stack.pop();
                res++;
            }
        }
        System.out.println(res*2);
    }

}
