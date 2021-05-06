package Leetcode.huawei;

import java.util.Arrays;
import java.util.HashMap;

public class MinSteps {
    public int minStep(int cur,String s,HashMap<Character,Integer> map){
        int res=0;
        int[] step = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                return -1;
            }
            step[i] = Math.abs(cur-map.get(s.charAt(i)))>map.size()/2?
                    map.size()-Math.abs(cur-map.get(s.charAt(i))) : Math.abs(cur-map.get(s.charAt(i)));
        }
        Arrays.sort(step);

        return 0;
    }
    public static void main(String[] args) {
        String inS = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<inS.length();i++){
            map.put(inS.charAt(i),i);
        }
        String check = "lmx";

    }
}
