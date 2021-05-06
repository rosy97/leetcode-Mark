package Leetcode.byteDance;

import java.util.Set;

//想尽量选择一个远离人群的位置。
// 已知由0和1组成的环形数组表示当前排的座位情况,其中1表示已被选座，0表示空座位
//请问小杰所选座位和最近人的座位距离数最大是多少？
public class ChooseSeat {

    public static Set<Integer> set;
    public static int res = 0;
    public static int maxDistance(int[] arr, Set<Integer> set){
        for(int i=0;i<arr.length;i++){
            int len = arr.length/2;
            if(arr[i]==0){
                int dis;
                for(int j:set){
                    dis = i>j?i-j:j-i;
                    dis = dis>len?arr.length-dis:dis;
                    res = Math.max(dis,res);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //输入描述:
        //第一行是一个正整数N(2<=N<=1000)，表示数组长度
        //第二行是N个数K1,K2...Kn组成的环形数组， Kn为0或1
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        set = new HashSet<>();
//        for(int i=0;i<n;i++){
//            arr[i]=in.nextInt();
//            if(arr[i]==1){
//                set.add(i);
//            }
//        }
//        System.out.println(maxDistance(arr,set));
        char a = '0';//65  90   48  57
        char z = '9';//65  90
        char c = '9';//49
        char b = (char) (c-1);
        System.out.println(Integer.valueOf(z));
        System.out.println(b);


    }
}
