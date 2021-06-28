package Leetcode.str;

//leetcode 483

//输入："4681"
//输出："8"
//解释：4681 的 8 进制是 11111。
public class GoodBaseK {
    public String smallestGoodBase(String n){
        Integer i = Integer.valueOf(n);
        int k = i/2;
        while(i-1>0){
            i=(i--)/k;
        }
        return  "";
    }
}
