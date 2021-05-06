package Leetcode.alibaba;

public class Bag01 {
    int[] vs = {0,1,3,8,5};
    int[] ws = {0,1,2,5,4};

    //递归求解
    public int ks1(int i, int c){//i个宝物、初始包容量为c时：最大价值
        int result = 0;
        if(i==0 || c==0){
            return 0;
        }else if(ws[i] > c){
            //单独装不下第i件时：
            return ks1(i-1,c);
        }else {
            //ws[i] <= c，可以装下第i件
            int tmp1 = ks1(i-1,c); //不装
            int tmp2 = ks1(i-1,c-ws[i])+vs[i]; //装
            return tmp1>tmp2?tmp1:tmp2;
        }
    }

    //用数组保存已经求得的结果
    Integer[][] res = new Integer[5][11]; //res[4][10]
    public int ks2(int i, int c){//i个宝物、初始包容量为c时：最大价值
        if(res[i][c]!=null){
            return res[i][c];
        }
        if(i==0 || c==0){
            res[i][c]=0;
        }else if(ws[i] > c){
            //单独装不下第i件时：
            res[i][c] = ks2(i-1,c);
        }else {
            //ws[i] <= c，可以装下第i件
            int tmp1 = ks2(i-1,c); //不装
            int tmp2 = ks2(i-1,c-ws[i])+vs[i]; //装
            res[i][c] = tmp1>tmp2?tmp1:tmp2;
        }
        return res[i][c];
    }

    public static void main(String[] args) {
        Bag01 bag = new Bag01();
        System.out.println(bag.ks1(4, 10));
        System.out.println(bag.ks2(4, 10));
    }
}
