package Leetcode.dfsAndBfs;

//dfs：截止条件、遍历筛选（修改状态）、回溯

import java.util.ArrayList;
import java.util.List;

//leetcode93 复原ip地址：每一位0~255
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
public class RestoreIpAddr {
    static List<String> res = new ArrayList<>();
    public static void restore(String s, int len, StringBuilder sb) {
        //len 当前层数
        if(s.length()>12)
            return;
        if(len==4 && sb.length()-len+1==s.length()){//截止条件
            res.add(new String(sb));
            System.out.println(sb);
            return;
        }
        int curIdx = sb.length()-len;
        for(int j=1;j<=3;j++){
            if(curIdx+j<=s.length()){
                String substring = s.substring(curIdx, curIdx + j);
                if((substring.charAt(0)=='0'&&substring.length()>1) || Integer.valueOf(substring)>255){
                    continue;
                }
                if(len==3){
                    sb.append(substring);
                }else{
                    sb.append(substring+".");
                }
                restore(s,len+1, sb);
                //恢复状态（回溯）
                sb.delete(curIdx+len,sb.length());
            }
        }
    }

    public static void main(String[] args) {
        restore("0000",0,new StringBuilder());
    }
}
