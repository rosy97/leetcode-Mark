package Leetcode;

//leetcode
//机器人只能向右向下走一步，具有障碍项。
public class RobotWays {
    public int rightPlus(int[][] a,int i, int j){
        if (i<a.length && (j+1)<a[0].length){
            return a[i][j]+a[i][j+1];
        }
        return 1;
    }

    public int downPlus(int[][] a,int i, int j){
        if ((i+1)<a.length && j<a[0].length){
            return a[i][j]+a[i+1][j];
        }
        return 1;
    }

    public int update(int count, int[][] a,int i, int j){
        //终止条件，若为最后一个元素
        if ((i+1)==a.length && (j+1)==a[0].length && a[i][j]!=1){
            count++;
        }
        if(rightPlus(a, i, j)==0){
            count = update(count,a,i,j+1);
        }
        if(downPlus(a, i, j)==0){
            count = update(count,a,i+1,j);
        }
        return count;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int result;
        result = update(0, obstacleGrid,0,0);
        return result;
    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        //n行，m列
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        RobotWays robotWays = new RobotWays();
        System.out.println(robotWays.uniquePathsWithObstacles(a));
    }
}
