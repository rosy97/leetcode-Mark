package Leetcode;

public class EasyMoney {

    public boolean isover(int[] arr){
        int countOfFive=0;
        int countOfTen=0;

        for(int e:arr){
            if(e==5){
                countOfFive++;
            }else if(e==10){
                countOfTen++;
                countOfFive--;
            }else {
                if(countOfTen>0){
                    countOfTen--;
                    countOfFive--;
                }else {
                    countOfFive-=3;
                }
            }
        }
        return countOfFive>=0;
    }

}
