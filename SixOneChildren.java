package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class SixOneChildren {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] num = new int[N];
        for(int i = 0 ; i < N ; i++){
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        int min = 0;
        for(int i = 2 ; i < N ; i++){
            min = Math.max(min,num[i]-num[i-2]);
        }
        System.out.print(min);
        in.close();
    }

}
