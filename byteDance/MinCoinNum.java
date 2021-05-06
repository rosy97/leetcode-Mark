package Leetcode.byteDance;

import java.util.Scanner;

public class MinCoinNum {
    //面值1元、4元、16元、64元共计4种硬币，其中面值依次成比例
    public static int minNum(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==4 ||n==16 ||n==64){
            return 1;
        }else {
            if(n>64){
                return Math.min(Math.min(minNum(n-4),minNum(n-1)),Math.min(minNum(n-64),minNum(n-16)))+1;
            }else if(n>16){
                return Math.min(Math.min(minNum(n-4),minNum(n-1)),minNum(n-16))+1;
            }else if(n>4){
                return Math.min(minNum(n-4),minNum(n-1));
            }else {
                return minNum(n-1)+1;
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cash = 1024-n;
        int coin64 = cash/64;
        int coin16 = cash%64/16;
        int coin4 = cash%64%16/4;
        int coin1 = cash%64%16%4;
        System.out.println(coin1 + coin4 + coin16 + coin64);
    }
}
