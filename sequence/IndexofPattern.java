package Leetcode.sequence;

public class IndexofPattern {

    public int idxof(String text,String pattern){//蛮力求解  O(mn)
        int tlen = text.length();
        int plen = pattern.length();

        for(int i=0;i<tlen;i++){
            int j=0;
            if(text.charAt(i)==pattern.charAt(j)){
                int start = i;
                while(j<plen && text.charAt(start)==pattern.charAt(j)){
                    start++;
                    j++;
                }
                if(j==plen)
                    return i;
                else// !=
                    continue;
            }else
                continue;
        }
        return -1;
    }

    public int kmp(String text,String pattern){

        return -1;
    }

    public static void main(String[] args) {
        IndexofPattern ins=new IndexofPattern();

        String s1="hello world";
        String s2="lmx";

        System.out.println(ins.idxof(s1, s2));
    }


}
