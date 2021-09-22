package Leetcode.microSoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TotalMod3 {
    //0081，只替换（包括不替换）其中的一位数字为0~9，使可以被3整除
    // 返回所有的可以整除3的变换数量
    public int solution(String S) {
        // write your code in Java SE 8
        char[] chs = S.toCharArray();
        int ans = 0;
        for (int i = 0; i < chs.length; i++) {
            int sum = 0, md = 0;
            for (int j = 0; j < chs.length; j++) {
                if (i == j)
                    continue;
                sum += Integer.valueOf(chs[j]);
            }
            md = sum % 3;
            if (md == 0)
                ans += 4;
            else if (md == 1)
                ans += 3;
            else
                ans += 3;
        }

        int all = 0;
        for (int i = 0; i < chs.length; i++) {
            all += Integer.valueOf(chs[i]);
        }

        System.out.println(ans);
        return all % 3 != 0 ? ans : ans - S.length() + 1;
    }

    public int solution2(String S) {
        int N = S.length();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = S.charAt(i) - '0';
        }
        Set<Integer> set = new HashSet<>();
        int max = N * 9;
        for (int i = max; i > 0; i -= 3) {
            set.add(i);
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            int temp = nums[i];
            for (int j = 0; j < 10; j++) {
                nums[i] = j;
                int sum = Arrays.stream(nums).sum();
                if (set.contains(sum)) count++;
            }
            nums[i] = temp;
        }
        return count;
    }
}
