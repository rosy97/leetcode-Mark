package Leetcode.str;

import java.util.HashMap;

public class DistanceOfStr {
    public static int distance(String s1, String s2){
        if(s1.length()!=s2.length())
            return -1;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        HashMap<String,Integer> map = new HashMap<>();
        int res = s1.length();
        int maxNum = 1;

        for(int i = 0; i<s1.length();i++){
            if(ch1[i]==ch2[i]){
                res--;
            }else {
                if(map.containsKey(""+ch1[i]+ch2[i])){
                    map.put(""+ch1[i]+ch2[i],map.get(""+ch1[i]+ch2[i])+1);
                    maxNum = Math.max(maxNum,map.get(""+ch1[i]+ch2[i]));
                }else
                    map.put(""+ch1[i]+ch2[i],1);
            }

        }
        return Math.max(0,res-maxNum);
    }

    public static void main(String[] args) {
        System.out.println(distance("aaa", "abc"));
    }
}
