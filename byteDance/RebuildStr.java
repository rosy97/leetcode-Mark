package Leetcode.byteDance;

import java.util.Scanner;

public class RebuildStr {
    public static String rebuild1(String s){
        int len = s.length();
        if(len<3){
            return s;
        }
        int i=0;
        int j;
        while(i<len){
            //处理wooooooow
            int num=1;
            j=i;
            while(j<len-1 && s.charAt(j)==s.charAt(j+1)){
                num++;
                j++;
            }
            if(num>2){
                s=s.substring(0,j-num+3)+s.substring(j+1);
                i=j-num+1;
            }
            i++;
            len=s.length();
        }
        return s;
    }
    public static String rebuild2(String s){
        int len = s.length();
        if(len<4){
            return s;
        }
        int j=0;
        while(j<len){
            //处理helloo
            if(j+3<len && s.charAt(j)==s.charAt(j+1) && s.charAt(j+2)==s.charAt(j+3)){
                s=s.substring(0,j+3)+s.substring(j+4);
                j=j+2;
            }
            len=s.length();
            j++;
        }
        return s;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for(int i=0;i<n;i++){
            strs[i]=in.next();
        }

        for(int i=0;i<n;i++){
            System.out.println(rebuild2(rebuild1(strs[i])));
        }


    }
}
