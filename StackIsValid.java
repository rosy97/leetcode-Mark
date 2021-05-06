package Leetcode;

import java.util.Stack;

public class StackIsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
                continue;
            }
            if(!stack.empty()){
                char c  = stack.pop();
                if(s.charAt(i)==')' && c!='('){
                    return false;
                }
                if(s.charAt(i)==']' && c!='['){
                    return false;
                }
                if(s.charAt(i)=='}' && c!='{'){
                    return false;
                }
            }else {
                return false;
            }

        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        StackIsValid stackIsValid = new StackIsValid();
        System.out.println(stackIsValid.isValid("()"));
    }
}
