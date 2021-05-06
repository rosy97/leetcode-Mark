package Leetcode.dp;

import java.util.HashSet;
import java.util.Scanner;

public class minPack {

    public static int ans=0;
    public static int miin=999;
    public static void res(int miin,int ans,HashSet<Integer> indexSet,HashSet<String> set,String[][] packages,String[] price){
        for(int i=0;i<packages.length;i++){
            if(indexSet.contains(i)){
                continue;
            }
            indexSet.add(i);
            ans+=Integer.valueOf(price[i]);
            for(String inn:packages[i]){
                if(set.contains(inn)){
                    set.remove(inn);
                    if(set.isEmpty()){
                        miin = Math.min(ans,miin);
                        return;
                    }
                }

            }
            res(miin,ans,indexSet,set,packages,price);
            for(String inn:packages[i]){
                set.add(inn);
            }
            indexSet.remove(i);
            ans-=Integer.valueOf(price[i]);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] instr = new String[4];
        for(int i=0;i<4;i++){
            instr[i]=in.nextLine();
        }
        int n = Integer.valueOf(instr[0]);
        String[] whole = instr[1].split(" ");
        String[][] packages=new String[whole.length][];
        for(int i=0;i<whole.length;i++){
            packages[i]=whole[i].split(",");
        }
        String[] price = instr[2].split(" ");
        String[] value = instr[3].split(" ");

        HashSet<String> set = new HashSet();
        HashSet<Integer> indexSet = new HashSet();
        for(String s:value){
            set.add(s);
        }
        res(miin,ans,indexSet,set,packages,price);
        System.out.println(miin);


    }
}
