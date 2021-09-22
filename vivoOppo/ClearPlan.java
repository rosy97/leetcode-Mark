package Leetcode.vivoOppo;

public class ClearPlan {
    //返回plan能否顺利执行，满仓配送会爆仓-->false
    public static boolean overSize(int[] status, int[] plan){
        //status[i] 表示第i+1个仓库：1满仓；0空仓
        int ans=0;
        //plan[i]>0：表示第i天会向仓库plan[i]配送货物，
        //plan[i]==0：可以清空一个仓库
        for(int i=0;i<plan.length;i++){
            if(plan[i]>0){
                if(status[plan[i]-1]==1){
                    if(ans==0)
                        return false;
                    else
                        ans--;
                }
                else{
                    //空仓
                    status[plan[i]-1]=1;
                }
            }
            else {//plan[i]==0
                ans++;
            }
        }
        return true;
    }
}
