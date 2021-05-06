package Leetcode;

//leetcode 413. 等差数列划分
//等差数列的划分

public class ArithmeticSequence_sprt {

    public int sperate(int n){
        return (n-1)*(n-2)/2;
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A==null || A.length<3) {
            return 0;
        }
        int l = A.length;
        int[] Q = new int[l-1];

        for(int i=0; i+1<l; i++){
            Q[i] = A[i+1]-A[i];
        }

        int count = 0;
        for(int i=0; i<l-1;){
            int startIndex = i;
            while (i+1<l-1 && Q[i]==Q[i+1]){
                i++;
            }
            int endIndex = i;
            count+=sperate(endIndex-startIndex+2);
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        ArithmeticSequence_sprt arithmeticSequence_sprt = new ArithmeticSequence_sprt();
        System.out.println(arithmeticSequence_sprt.numberOfArithmeticSlices(a));
    }

}
