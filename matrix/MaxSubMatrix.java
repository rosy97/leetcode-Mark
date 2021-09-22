package Leetcode.matrix;

public class MaxSubMatrix {
    public static void main(String[] args) {
        MaxSubMatrix mx = new MaxSubMatrix();
//        System.out.println(mx.subMaxMatrix(new int[][]{
//                {-3,5,-1,5},
//                {2,4,-2,4},
//                {-1,3,-1,3}
//        }));
        System.out.println(maxSum(new int[][]{
                {-3,5,-1,5},
                {2,4,-2,4},
                {-1,3,-1,3}
        }));
    }
    public static int maxSum(int[][] arr){
        if(arr==null||arr.length==0||arr[0].length==0)
            return 0;
        int res=Integer.MIN_VALUE;
        int cur;
        int[] h=null;
        for(int i=0;i<arr.length;i++){//遍历行
            h=new int[arr[i].length];//初始化，同每一行的长度
            for(int j=i;j<arr.length;j++){
                //列数起点与当前行数一样
                cur=0;
                for(int k=0;k<arr[j].length;k++){
                    h[k]+=arr[j][k];
                    cur+=h[k];
                    res=Math.max(cur,res);
                    cur=cur<0?0:cur;
                }
            }
        }
        return res;
    }
}
