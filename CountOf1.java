package Leetcode;

//	剑指 Offer 43
//0~n中：1的个数

//个位上的1，每10次加1 ---->n/10
//十位上的1，每百次加10 ---->n/100
//百位上的1，每千次加100 ---->n/1000
public class CountOf1 {
    public int countDigitOne(int n) {
        if (n==0)
            return 0;
        else if(n<10)
            return 1;
        int m = n;
        int power = 0;
        int count = 0;
        while(m/10 > 0){
            m/=10;
            power++; //n为(power+1)位数
        }
        //计算最高位1的个数
        if(n/(int)(Math.pow(10,power))>1){
            count += (int)(Math.pow(10,power));
        }else {//n/(10^power)==1
            count += (n-(int)(Math.pow(10,power))+1);
        }
        //计算低位1的个数
        int current,oneTenth;
        for(; power>0; power--){
            current = (int)(Math.pow(10,power));
            oneTenth = (int)(Math.pow(10,power-1));
            count += n/current * oneTenth;
            if(n%current >= oneTenth*2){
                count += oneTenth;
            }else if(n%current >= oneTenth) {
                count += (n%current-oneTenth+1);}
        }

        return count;
    }

    public static void main(String[] args) {
        CountOf1 count = new CountOf1();
        System.out.println(count.countDigitOne(110));
        //System.out.println(5 / 10);
    }
}
