package Leetcode.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class SqlOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        int res=0;
        for(int i=0;i<n;i++){
            String inS = in.nextLine();
            String[] s = inS.split(" ");
            if(s.length<2){
                continue;
            }
            if(!map.containsKey(s[1])){
                map.put(s[1],1);
            }else {
                map.put(s[1],map.get(s[1])+1);
            }
        }
        for(String name:map.keySet()){
            if(map.get(name)>1){
                res++;
            }
        }
        System.out.println(res);
    }
}

