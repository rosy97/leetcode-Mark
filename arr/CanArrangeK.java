package Leetcode.arr;

import java.util.HashMap;

public class CanArrangeK {
    public static boolean canArrange(int[] arr, int k) {
        int sum=0,n=arr.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int arrangeK = arr[i]%k;
            if(!map.containsKey(arrangeK)){
                map.put(arrangeK,1);
            }else {
                map.put(arrangeK,map.get(arrangeK)+1);
            }
        }
        if(sum%k!=0) return false;
        for(int i:arr){
            if(map.containsKey(-i%k) && map.get(-i%k)>0){
                map.put(-i%k,map.get(-i%k)-1);
                if(map.get(-i%k)<0)
                    return false;
            }
            else if(map.containsKey((k-i%k)%k)){
                map.put((k-i%k)%k,map.get((k-i%k)%k)-1);
                if(map.get((k-i%k)%k)<0)
                    return false;
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{-4,-7,5,2,9,1,10,4,-8,-3}, 3));
    }
}
