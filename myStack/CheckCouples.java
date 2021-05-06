package Leetcode.myStack;

import java.util.Stack;

public class CheckCouples {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c:ch){
            if(c==')'||c=='}'||c==']'){
                if(stack.isEmpty())
                    return false;
                else{
                    char left = stack.pop();
                    if((c==')'&&left=='(')||(c==']'&&left=='[')||(c=='}'&&left=='{'))
                        continue;
                    else
                        return false;
                }

            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        CheckCouples checkCouples =new CheckCouples();
        System.out.println(checkCouples.isValid("(){}}{"));
    }
}
