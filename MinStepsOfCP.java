package Leetcode;

//leetcode 650
//只有copyAll & Paste，最开始有一个A
//输出能够打印出 n 个 'A' 的最少操作次数。
public class MinStepsOfCP {
    public int minSteps(int n) {
        if (n==1){
            return 0;
        }
        if (n==2){
            return n;
        }
        //判断是否为质数
        for(int j=2;j<=Math.sqrt(n);j++){
            if(n%j==0){
                //不为质数
                return j+minSteps(n/j);
            }
        }
        //若为质数
        return n;
    }

    public static void main(String[] args) {
        MinStepsOfCP minStepsOfCP = new MinStepsOfCP();
        System.out.println(minStepsOfCP.minSteps(9)); //输出6
    }
}
