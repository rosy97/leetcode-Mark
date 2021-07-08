package Leetcode.arr;

import java.util.Arrays;

//leetcode 1011
//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

//输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5,输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10

public class ShipWithinDays {
    public static int shipWeight(int[] weights, int D) {
        // 二分查找：日运载量的左右边界
        // left 最大重量（至少刚好运送最重货物）
        // right重量之和（刚好一日送完）
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {//天数不够，则需减少运载量
                right = mid;
            } else {//天数超出，需增大运载量
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        System.out.println(shipWeight(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }
}
