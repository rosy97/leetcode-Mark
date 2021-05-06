package Leetcode.str;

public class ComnSubstring {

    //动态规划
    public static String common(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        //dp[i][j]：以s1[i]、s2[j]为结尾的公共子串的最长值
        //下标0~l1
        int[][] dp = new int[l1][l2];
        int max = 0;
        int in1=0;
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(i==0 || j==0){
                    dp[i][j]=s1.charAt(i)==s2.charAt(j)?1:0;
                }else {
                    dp[i][j]=s1.charAt(i)==s2.charAt(j)?dp[i-1][j-1]+1:0;
                }
                if(max<dp[i][j]){
                    max=dp[i][j];
                    in1=i;
                }
            }
        }

        return s1.substring(in1-max+1, in1+1);
    }

    //滑动数组：枚举 A 和 B 所有的对齐方式。
    //对齐的方式有两类：第一类为 A 不变，B 的首元素与 A 中的某个元素对齐；第二类为 B 不变，A 的首元素与 B 中的某个元素对齐。
    //每种方式遍历一次，寻找公共最长子串
    public static String common1(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int maxLen1 = 0;
        int in1=0;
        for(int i=0;i<l1;i++){
            //遍历s1,以s2首字符为首对齐
            int count=0;
            int maxRowLen = 0;//每种对齐方式的最长长度
            int rowIn1=0;
            for(int j=0,k=i;j<l2 && k<l1;j++,k++){
                count = s1.charAt(k)==s2.charAt(j)?count+1:0;
                if(maxRowLen<count){
                    maxRowLen=count;
                    rowIn1=k;
                }
            }
            if(maxLen1<maxRowLen){
                maxLen1=maxRowLen;
                in1=rowIn1;
            }
        }

        int maxLen2 = 0;
        int in2=0;
        for(int i=0;i<l2;i++){
            //遍历s2,以s1首字符为首对齐
            int count=0;
            int maxRowLen = 0;//每种对齐方式的最长长度
            int rowIn2 = 0;
            for(int j=0,k=i;j<l1 && k<l2;j++,k++){
                count = s2.charAt(k)==s1.charAt(j)?count+1:0;
                if(maxRowLen<count){
                    maxRowLen = count;
                    rowIn2 = k;
                }
            }
            if(maxLen2<maxRowLen){
                maxLen2 = maxRowLen;
                in2=rowIn2;
            }
        }

        return maxLen1>maxLen2?s1.substring(in1-maxLen1+1,in1+1):s2.substring(in2-maxLen2+1,in2+1);
    }

    public static void main(String[] args) {

        System.out.println(common("hlofcellof", "lofcvdsw"));
        System.out.println(common1("hghbdellof", "lofghbd"));
    }
}
