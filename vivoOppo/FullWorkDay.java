package Leetcode.vivoOppo;


public class FullWorkDay {

    public static void main(String[] args) {
        System.out.println(fullDay(10));
    }

    public static int ans;

    // n天时间
    // 困难工作需要4天、一般工作2天、简单工作1天
    // n天可以完成的所有工作组合数
    // n=3，返回3，分别为[1,1,1]、[1,2]、[2,1]
    public static int fullDay(int n) {
        if(n==0)
            return 0;
        work(n);
        return ans;
    }

    public static void work(int n) {
        if (n == 0) {
            ans++;
            return;
        }
        if(n>=4){
            work(n-4);
            work(n-2);
            work(n-1);
        }
        else if(n>=2){
            work(n-2);
            work(n-1);
        }
        else
            work(n-1);
    }
}
