package Leetcode;

import java.util.Arrays;

public class IsContinuous {
    public boolean isCon(int[] numbers) {
        Arrays.sort(numbers);
        if(numbers[0]==numbers[1]&&numbers[0]==0&&numbers[2]==numbers[3]&&numbers[3]==0){//4个0
            return true;
        }else if(numbers[0]==numbers[1]&&numbers[0]==0&&numbers[1]==numbers[2]&&numbers[4]-numbers[3]<=4&&numbers[4]!=numbers[3]){//3个0
            return true;
        }else if(numbers[0]==numbers[1]&&numbers[0]==0&&numbers[4]-numbers[2]<=4&&numbers[4]!=numbers[3]&&numbers[2]!=numbers[3]){//2个0
            return true;
        }else if(numbers[0]==0&&numbers[4]-numbers[1]<=4&&numbers[4]!=numbers[3]&&numbers[2]!=numbers[3]&&numbers[2]!=numbers[1]){//1个0
            return true;
        }else if(numbers[4]-numbers[3]==1&&numbers[3]-numbers[2]==1&&numbers[2]-numbers[1]==1&&numbers[1]-numbers[0]==1){//没有0
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        IsContinuous line = new IsContinuous();

    }
}
