package Leetcode.tencent;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] times=new int[n][k];

        for(int i = 0; i < n; i++){
            int t=sc.nextInt();
            for(int j = 0; j < k; j++){
                times[i][j]=t*(j+1);
            }
        }
        for(int q=0;q<k;q++){
            int res=Integer.MAX_VALUE;
            int mini=0,minj=0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < k; j++){
                    if(res>times[i][j]){
                        res=times[i][j];
                        mini=i;
                        minj=j;
                    }
                }
            }
            times[mini][minj]=Integer.MAX_VALUE;
            System.out.println(mini+1);
        }
    }
}
