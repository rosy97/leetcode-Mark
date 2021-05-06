package Leetcode;

// "nowcoder. a am I" --> "I am a nowcoder."
public class ReverseSentence {
    public String myReverse(String str){
        String[] cutStr = str.split(" ");
        String result ="";
        for(int i=cutStr.length-1;i>=0;i--){
            result += (cutStr[i]+" ");
        }
//        for(String ss:cutStr){
//            System.out.println(ss);
//        }
        return result;
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.myReverse("nowcoder. a am I"));
    }
}
