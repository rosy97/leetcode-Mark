package Leetcode;

import java.util.Scanner;

public class Hui_number {
    //回型数
    public static void main(String[] args){
        System.out.print("请输入阶数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //输入阶数
        int[][] arr = new int[n][n]; //初始化数组
        arr[0][0] = 1;
        for (int k=1;k<=2*n-1;k++){
            //每个k只遍历一行或者一列
            switch (k%4)
            {
                case 1:
                    for(int i=k/4,j=k/4;j<n-k/4;j++){
                        if(j==0){continue;}
                        arr[i][j] = arr[i][j-1]+1;
                        //System.out.print(arr[i][i]+" ");
                    }

                case 2:
                    for(int i=k/4+1,j=n-k/4-1;i<n-k/4;i++){
                        arr[i][j] = arr[i-1][j]+1;
                    }

                case 3:
                    for(int i=n-k/4-1,j=n-k/4-2;j>=k/4;j--){
                        arr[i][j] = arr[i][j+1]+1;
                    }

                case 0:
                    for(int i=n-k/4-2,j=k/4;i>=k/4+1;i--){
                        arr[i][j] = arr[i+1][j]+1;
                    }
            }

        }

        //遍历数组
        for (int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
