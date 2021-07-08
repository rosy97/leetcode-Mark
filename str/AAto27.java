package Leetcode.str;

//leetcode 168
//26进制转换：循环除26，将每次的余数作为低位的数值。
public class AAto27 {
    public static String convertToTitle(int columnNumber) {
        //10进制转26进制
        StringBuilder sb = new StringBuilder();
        if(columnNumber%26==0&&columnNumber>26){
            return (char)(columnNumber/26-1+64)+""+"Z";
        }

        while(columnNumber>26){
            sb.append((char)(columnNumber%26+64));
            columnNumber/=26;
        }
        sb.append((char)(columnNumber+64));
        return new String(sb.reverse());
    }

    public static String convertToTitle1(int cn) {
        StringBuilder sb = new StringBuilder();
        while (cn > 0) {
            cn--;
            sb.append((char)(cn % 26 + 'A'));
            cn /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/excel-sheet-column-title/solution/gong-shui-san-xie-cong-1-kai-shi-de-26-j-g2ur/
//    来源：力扣（LeetCode）


    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle1(26));
    }
}
