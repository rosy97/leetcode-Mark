package Leetcode.str;

public class ReverseStr {
    public static void main(String[] args) {
        String s = "(u(love)(23)(45)me)";//--->me4523loveu
        String ans = "",cur="";
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='('){
                cur = new String(sb);
                sb =  new StringBuilder();
                ans = cur + ans;
                continue;
            }
            if(s.charAt(i)==')'){
                cur = new String(sb);
                sb =  new StringBuilder();
                ans = cur + ans;
                continue;
            }
            sb.append(s.charAt(i));
        }
        ans = new String(sb)+ans;
        System.out.println(ans);
    }
}
