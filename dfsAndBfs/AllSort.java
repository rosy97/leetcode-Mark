package Leetcode.dfsAndBfs;

import java.util.ArrayList;
import java.util.List;

//求char[] 的全排列
//dfs加回溯：截止条件、筛选条件、遍历候选节点、
//思路：1.截止条件  2.按序遍历  3.判断标志（数据是否已经遍历） 4.状态恢复
public class AllSort {
    public static List<Character> res = new ArrayList<>();
    public static void allst(char[] str){
        if(res.size()==str.length){
            System.out.println(res);
            return;
        }
        for(int i=0;i<str.length;i++){
            char cur = str[i];
            if(cur!=' '){
                res.add(cur);
                str[i]=' ';//修改标志位
                allst(str);
                str[i]=cur;
                res.remove(res.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        allst("ABCD".toCharArray());
    }
}
