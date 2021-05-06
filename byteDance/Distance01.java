package Leetcode.byteDance;

import java.util.Scanner;

//1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
//2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
//第一行包含空格分隔的两个数字 N和D
//第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
public class Distance01 {

    //一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
    public static int num(int n, int d,int[] place){
        if(n<3)
            return 0;
        int[] dp = new int[n];
        dp[2]=place[2]-place[0]<=d?1:0;
        for(int i=3;i<n;i++){
            int j=i-1,num=0;
            while (j>=0 && place[i]-place[j]<=d){
                num++;
                j--;
            }
            dp[i]=num>=2?dp[i-1]+num*(num-1)/2:dp[i-1];

        }
        return dp[n-1]%99997867;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//N个建筑物
        int d = in.nextInt();
        int[] place = new int[n];//N个建筑物的的位置
        for(int i=0;i<n;i++){
            place[i]=in.nextInt();
        }
        System.out.println(num(n,d, place));
    }
}
