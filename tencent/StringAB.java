package Leetcode.tencent;

import java.util.Scanner;

public class StringAB {
    public static boolean queal(String a,String b){
        if( a.length()%2==1)
            return a.equals(b);
        else{
            String a1=a.substring(0, a.length()/2);
            String a2=a.substring(a.length()/2);
            String b1=b.substring(0, a.length()/2);
            String b2=b.substring(a.length()/2);
            return (queal(a1,b1)&&queal(a2,b2))||(queal(a1,b2)&&queal(a2,b1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t*2; i++){
            String a = sc.next();
            String b = sc.next();
            if(queal(a,b)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
