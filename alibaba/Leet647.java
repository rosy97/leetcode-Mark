package Leetcode.alibaba;

//输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
public class Leet647 {
    public static int countSubstrings(String s){
        int count=0;
        for(int i=0; i<s.length();i++){
            //奇数
            int left=i,right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
            //偶数
            left=i;
            right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    //是否为回文串
    public static boolean isSubstrings(String s){
        int len = s.length();
        if(len==0 || len==1){
            return true;
        }
        if(len%2!=0){
            int left=len/2,right=len/2;
            while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            return right-left-1==len;
        }else {
            int left=len/2-1,right=len/2;
            while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            return right-left-1==len;
        }
    }

    //输入：a = "ulacfd", b = "jizalu"
    //输出：true
    //解释：在下标为 3 处分割：
    //aprefix = "ula", asuffix = "cfd"
    //bprefix = "jiz", bsuffix = "alu"
    //那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
    public static boolean checkPalindromeFormation(String a, String b) {
        int lena=expandFromMid(a);
        int lenb=expandFromMid(b);
        if(lena>lenb){
            //
        }
        return true;
    }
    public static int expandFromMid(String a){
        int left=(a.length()-1)/2;
        int right = a.length()%2==0 ? left+1 : left;
        while (left>=0 && right<a.length() && a.charAt(left)==a.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("ulacfd", "jizalu"));
    }
}
