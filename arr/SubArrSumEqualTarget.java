package Leetcode.arr;

import java.util.HashSet;
import java.util.Scanner;

//01完全背包
//背包容量为m，在一组重量为w[]的物品中，是否存在一种组合刚好装满背包（任意一组）
public class SubArrSumEqualTarget {
    public static HashSet<Integer> set;
    public static String isOk(int m, int[] w, HashSet<Integer> set){
        for(int i=0;i<w.length;i++){
            if(set.contains(i)){
                continue;
            }
            if(w[i]==m){
                return "YES";
            }
            if(w[i]<m){
                set.add(i);
                String res = isOk(m-w[i],w,set);
                set.remove(i);
                if(res.equals("YES")){
                    return res;
                }else {
                    continue;
                }
            }
        }
        return "NO";
    }
    public static String isOk1(int m, int[] w, HashSet<Integer> set){
        for(int i=0;i<w.length&& !set.contains(i);i++){
            if(w[i]==m){
                return "YES";
            }
            if(w[i]<m){
                set.add(i);
                String res = isOk(m-w[i],w,set);
                set.remove(i);
                if(res.equals("YES")){
                    return res;
                }else {
                    continue;
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一行输入m,n
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[n];
        //第二行为长度为n的数组赋值
        for(int i = 0; i < n; i++){
            w[i]=sc.nextInt();
        }
//        System.out.println(isOk(m, w, new HashSet<>()));
        System.out.println(isOk1(m, w, new HashSet<>()));
    }
}
