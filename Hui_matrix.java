package Leetcode;

import java.util.ArrayList;

public class Hui_matrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int l1 = matrix.length;
        int l2 = matrix[0].length;
        int k = l1*2-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=1;i<=k;i++){
            switch(i%4){
                case 1:{
                    for(int count=0+(i/4);count<(l2-i/4);count++){
                        result.add(matrix[i/4][count]);
                    }
                    break;
                }
                case 2:{
                    for(int count=1+(i/4);count<(l1-i/4);count++){
                        result.add(matrix[count][l2-1-i/4]);
                    }
                    break;

                }
                case 3:{
                    for(int count=l2-2-(i/4);count>=(i/4);count--){
                        result.add(matrix[l1-1-i/4][count]);
                    }
                    break;

                }
                case 0:{
                    for(int count=l1-1-(i/4);count>=(i/4);count--){
                        result.add(matrix[count][i/4-1]);
                    }
                    break;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Hui_matrix ht = new Hui_matrix();
        System.out.println(ht.printMatrix(new int[][]{{1, 2, 3, 4, 5},{1,2,3,4,5}}));
    }
}
