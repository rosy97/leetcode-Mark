package Leetcode.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class WordFrequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int topN = Integer.valueOf(in.nextLine());
        int m = Integer.valueOf(in.nextLine());
//        System.out.println(topN + " " + m);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            String title = in.nextLine();//读入一行：标题
//            System.out.println("title:"+title);
            String text = in.nextLine();//读入一行：正文
//            System.out.println("text:"+text);
            String[] split = title.split(" ");
            for(String s:split){
                //遍历标题
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+3);
                }else {
                    map.put(s,3);
                }
            }
            split = text.split(" ");
            for(String s:split){
                //遍历正文
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else {
                    map.put(s,1);
                }
            }
        }
        //根据value值排序取出前topN
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<topN;i++){
            int val=0;
            String cur = "";
            for(String key:map.keySet()){
                if(map.get(key)>val){
                    val=map.get(key);
                    cur=key;
                }
            }
            if(i==topN-1)
                sb.append(cur);
            else
                sb.append(cur+" ");
            map.put(cur,0);
        }
        String res = new String(sb);
        System.out.println(res);//输出
    }
}
