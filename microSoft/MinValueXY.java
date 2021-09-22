package Leetcode.microSoft;

import java.util.Arrays;

public class MinValueXY {
    // 数组A[i]代表i处需要的能量，每个位置可以安置X/Y来消除能量。
    // X作用：抵消能量（产生1倍）；Y做用：产生2倍能量
    // 返回抵消所有A[i]的最小代价
    public int solution(int[] A, int X, int Y) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int sum = 0, right = 0, left = 0, idx = 0, val = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        for (int j = A.length - 1; j >= 0; j++) {
            right += A[j];//[j,len-1]
            if (right * 2 > sum) {//右边部分之和为总和的一半
                idx = j;
                break;
            }
        }
        left = sum - right;
        val = (A.length - idx) * Y;//右边部分全部先设Y
        if (X > Y)
            return val;
        while (idx >= 0) {//逐个对比中间索引之前为X的情况
            right -= A[idx];
            left -= A[idx - 1];
            left += A[idx];
            if (left > right)
                break;
            val = val - Y + X;
        }
        return val;
    }
}
