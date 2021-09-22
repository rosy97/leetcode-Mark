package Leetcode.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class MinCard0823 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] cards = new int[3][n];
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                cards[i][j]=in.nextInt();
            }
        }
        Arrays.sort(cards[0]);
        Arrays.sort(cards[1]);
        Arrays.sort(cards[2]);
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){

                }
            }
        }
        int begin0=0,end0=n-1;
        int begin1=0,end1=n-1;
        int begin2=0,end2=n-1;
        for(int i=0;i<n;i++){
            if(cards[0][begin0]<=cards[1][begin1] && cards[0][begin0]<=cards[2][begin2]){
                ans+=cards[0][begin0];
                begin0++;
                end1--;
                end2--;
            }
            else if(cards[1][begin1]<=cards[0][begin0] && cards[1][begin1]<=cards[2][begin2]){
                ans+=cards[1][begin1];
                begin1++;
                end0--;
                end2--;
            }
            else if(cards[2][begin2]<=cards[0][begin0] && cards[2][begin2]<=cards[1][begin1]){
                ans+=cards[2][begin2];
                begin2++;
                end0--;
                end1--;
            }

        }

        System.out.println(ans);
    }
}
