package Leetcode.dp;


//有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置
//路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
public class MinPath {

    public static int minValue(int[][] map){
        int row = map.length;
        int col = map[0].length;
        int[][] dp = new int[row][col];//dp[i][j] 表示到达对应格子的最小路径和
        dp[0][0] = map[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0){
                    continue;
                }else if(i==0){
                    dp[i][j]=dp[i][j-1]+map[i][j];
                }else if(j==0){
                    dp[i][j]=dp[i-1][j]+map[i][j];
                }else {
                    dp[i][j] = dp[i][j-1]<dp[i-1][j] ? dp[i][j-1]+map[i][j] : dp[i-1][j]+map[i][j];
                }
            }
        }
        return dp[row-1][col-1];
    }
    public static void main(String[] args) {

        System.out.println(minValue(new int[][]{{1,1,1},{1,2,3}}));
    }
}
