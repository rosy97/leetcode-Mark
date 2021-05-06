package Leetcode.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BalanceMass {
    public static HashSet<Integer> set;
    public static int maxMass(int[] arr,int n){
        int res=0,cur=0;
        for(int i=0;i<arr.length-1;i++){
            cur+=arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int start = in.nextInt();

        int[] index = new int[s2.length()];
        for(int i=0;i<s2.length();i++){
            index[i]=s1.indexOf(s2.substring(i,i+1));
            if(index[i]==-1){
                return;
            }
        }
        Arrays.sort(index);
        int res=0;
        for(int i=0;i<index.length-1;i++){
            res+=index[i+1]-index[i];
        }
        System.out.println(res);
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //第一行输入n
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        set=new HashSet<>();
//        //第二行为长度为n的数组赋值
//        for(int i = 0; i < n; i++){
//            arr[i]=sc.nextInt();
//        }
//        Arrays.sort(arr);
//    }

}
