package Leetcode.str;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//示例：
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
public class PartLabels {
    //划分字母区间
    public static List<Integer> partitionLabels(String S) {
        int[] lastIdx = new int[26];
        for(int i=0;i<S.length();i++){
            lastIdx[S.charAt(i)-'a']=i;//lastIdx记录26个字母出现的最后一次的索引
        }
        List<Integer> res = new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<S.length();i++){
            end=Math.max(end,lastIdx[S.charAt(i)-'a']);//end记录：当前项i 最后一次出现的索引
            if(i==end){//划分条件
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list.toString());

        System.out.println(partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}
